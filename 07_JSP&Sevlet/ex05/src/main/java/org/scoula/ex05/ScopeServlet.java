package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

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

        sc.setAttribute("scopeName", "applicationScope 값"); // application scope

        HttpSession session = request.getSession(); // session scope
        session.setAttribute("scopeName", "sessionScope 값");

        request.setAttribute("scopeName", "requestScope 값"); // request scope
        Member member = new Member("홍길동", "hong"); // member 생성자로 인스턴스 생성
        request.setAttribute("member", member);

        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}