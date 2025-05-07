package com.exemplo.ac2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CsrfUtil {

    private static final String SESSION_TOKEN_KEY = "csrfToken";

    public static String generateToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = UUID.randomUUID().toString();
        session.setAttribute(SESSION_TOKEN_KEY, token);
        return token;
    }

    public static String getSessionToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null) ? (String) session.getAttribute(SESSION_TOKEN_KEY) : null;
    }

    public static boolean isValidToken(HttpServletRequest request, String formToken) {
        String sessionToken = getSessionToken(request);
        return sessionToken != null && sessionToken.equals(formToken);
    }
}
