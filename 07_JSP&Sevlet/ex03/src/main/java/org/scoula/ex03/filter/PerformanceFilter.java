package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns={ "/*" }) // 모든 요청에 대해서 응답
public class PerformanceFilter implements Filter {
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();

        System.out.println("실행 시간: " + (end - start) + "ms");
        // -Dfile.encoding=UTF-8
        // tomcat의 vm 설정을 utf-8로 바꿔주기
    }
}

