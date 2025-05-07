package com.exemplo.ac2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mensagem")
public class MensagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String csrfToken = CsrfUtil.generateToken(request);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Enviar Mensagem</title></head><body>");
        out.println("<h2>Envie sua mensagem criptografada:</h2>");
        out.println("<form method='post' action='/mensagem'>");
        out.println("<input type='hidden' name='csrfToken' value='" + csrfToken + "'>");
        out.println("<input type='text' name='mensagem' placeholder='Digite a mensagem'/>");
        out.println("<button type='submit'>Enviar</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String csrfToken = request.getParameter("csrfToken");
        String encryptedMessage = request.getParameter("mensagem");

        if (!CsrfUtil.isValidToken(request, csrfToken)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF Token inválido");
            return;
        }

        try {
            String decrypted = AESUtil.decrypt(encryptedMessage);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Mensagem recebida:</h2>");
            out.println("<p><strong>Criptografada:</strong> " + encryptedMessage + "</p>");
            out.println("<p><strong>Descriptografada:</strong> " + decrypted + "</p>");
            out.println("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro na descriptografia");
        }
    }
}
