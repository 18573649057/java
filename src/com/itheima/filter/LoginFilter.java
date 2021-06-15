package com.itheima.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    检查登录
 */
@WebFilter(value = {"/index.html"})
public class LoginFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try{

            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;


            Object username = request.getSession().getAttribute("username");


            if(username == null || "".equals(username)) {

                response.sendRedirect(request.getContextPath() + "/login.html");
                return;
            }


            filterChain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
