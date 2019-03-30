package org.liuxinyu.project.util.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginCheck implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("emmm");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = (String) request.getSession().getAttribute("username");
        String requestURI = request.getRequestURI();

        if (requestURI.endsWith("demo_war_exploded/")||requestURI.endsWith("login.html") || username != null) {
            filterChain.doFilter(request, response);
            return;
    }
        if (username == null) {
            PrintWriter writer = response.getWriter();
            writer.print("\"<script type='text/javascript'>top.location = '/login';</script>\"");
            response.sendRedirect("/demo_war_exploded");
        }

    }

    @Override
    public void destroy() {

    }
}
