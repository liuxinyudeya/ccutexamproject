package org.liuxinyu.project.util.controller;

import org.liuxinyu.project.course.controller.CourseManager_Controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;

public class CheckLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        System.out.println(username);
        if (username!=null){// 通过
            filterChain.doFilter(request,response);
        }else{ //  重新登陆
            request.getRequestDispatcher("login.html").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
