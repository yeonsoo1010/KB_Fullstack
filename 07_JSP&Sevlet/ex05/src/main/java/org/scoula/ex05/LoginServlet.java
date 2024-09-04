package org.scoula.ex05;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // MIME 타입 설정
        // response.setContentType("text/html;charset=UTF-8");

        // 자바 I/O
        // PrintWriter out = response.getWriter();
        // html 작성 및 출력
        // out.print("<html><body>");
        // out.print("");
        // out.print("</body></html>");

        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}