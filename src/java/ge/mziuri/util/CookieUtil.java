package ge.mziuri.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void addCookie(String name, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
    }

    public static String getCookieValue(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
