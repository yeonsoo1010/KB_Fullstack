package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청에서 파라미터 얻기
        String userid = request.getParameter("userid");
        String password = request.getParameter("pw"); // jsp의 name과 같아야 함

        // 응답 내보내기
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        // html 작성 및 출력
        out.print("<html><body>");
        out.print("<h1>로그인 정보</h1>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + password + "<br>");
        out.print("</body></html>");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}