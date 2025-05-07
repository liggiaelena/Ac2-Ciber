package com.exemplo.ac2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

public class CsrfUtil {

    private static final String SESSION_TOKEN_KEY = "csrfToken";

    // Gera e armazena o token na sessão
    public static String generateToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = UUID.randomUUID().toString();
        session.setAttribute(SESSION_TOKEN_KEY, token);
        return token;
    }

    // Recupera o token da sessão
    public static String getSessionToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null) ? (String) session.getAttribute(SESSION_TOKEN_KEY) : null;
    }

    // Valida se o token enviado no formulário bate com o da sessão
    public static boolean isValidToken(HttpServletRequest request, String formToken) {
        String sessionToken = getSessionToken(request);
        return sessionToken != null && sessionToken.equals(formToken);
    }
}
