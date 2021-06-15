package com.pan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pan.service.Impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getParameter("method");

        if (method.equals("selectByPage")){
            selectByPage(req,resp);
        }
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        StudentServiceImpl service = new StudentServiceImpl();
        Page page = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        PageInfo  info = new PageInfo(page);
        String json = new ObjectMapper().writeValueAsString(info);

        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
