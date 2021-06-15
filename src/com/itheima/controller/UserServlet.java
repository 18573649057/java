package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.service.Imlp.UserServiceImpl;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=new User(username,password);
        List<User> list = service.login(user);
        if(list.size()!=0){
            req.getSession().setAttribute("username",username);
            resp.getWriter().write("true");
        }else {
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
