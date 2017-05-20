package ge.mziuri.servlet;

import ge.mziuri.dao.ExamDAO;
import ge.mziuri.dao.ExamDAOImpl;
import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.model.Exam;
import ge.mziuri.model.Post;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ge.mziuri.util.CookieUtil;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class AddExamServlet extends HttpServlet {
    
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50000 * 1024;
    private int maxMemSize = 50000 * 1024;
    private File file;

    private String imagePath;

    public void init() {

        filePath = getServletContext().getInitParameter("file-upload");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        Map<String, String> table = new HashMap<>();
        List<String> images = new ArrayList<>();
        try {
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            Random random = new Random();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String fileName = fi.getName();
                    String extention = FilenameUtils.getExtension(fileName);
                    String imageName = FilenameUtils.removeExtension(fileName);
                    if (fileName.lastIndexOf("\\") >= 0) {
                        fileName = imageName + random.nextInt() + "." + extention;
                        imagePath = fileName;
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        fileName = imageName + random.nextInt() + "." + extention;
                        images.add(fileName);
                        imagePath = fileName;
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    try {
                        fi.write(file);
                    } catch (Exception ex) {
                    }
                }
            }
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item1 = iter.next();
                if (!item1.getFieldName().equals("file")) {
                    table.put(item1.getFieldName(), item1.getString());
                }
            }
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        String description = table.get("description");
        String subject = table.get("subject");
        Date currDate = new Date();
        java.sql.Date date = new java.sql.Date(currDate.getTime());
        Time time = new Time(currDate.getTime());
        Exam exam = new Exam();
        exam.setSubject(subject);
        exam.setDate(date);
        exam.setTime(time);
        exam.setText(description);
        exam.setArchived(false);
        exam.setImages(images);
        ExamDAO examDAO = new ExamDAOImpl();
        examDAO.addExam(exam, Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)));
        RequestDispatcher rd = request.getRequestDispatcher("addExam.jsp");
        rd.forward(request, response);
    }
}
