package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.itheima.bean.Student;
import com.itheima.service.Imlp.StudentServiceImpl;
import com.itheima.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
private StudentService service=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getParameter("method");
        if(method.equals("selectByPage")){
            selectByPage(req,resp);
        }else if (method.equals("addStu")){
            addStu(req,resp);
        }else if(method.equals("updateStu")){
            updateStu(req,resp);
        }else if(method.equals("deleteStu")){
            deleteStu(req,resp);
        }
    }

    private void deleteStu(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String number = req.getParameter("number");
        service.deleteStu(number);
        try {
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage=" + currentPage + "&pageSize=" + pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateStu(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        Student stu=new Student();
        stu.setNumber(number);
        stu.setName(name);
        stu.setAddress(address);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(birthday);
            stu.setBirthday(parse);
            service.updateStu(stu);
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage=" + currentPage + "&pageSize=" + pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addStu(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        Student stu=new Student();
        stu.setNumber(number);
        stu.setName(name);
        stu.setAddress(address);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(birthday);
            stu.setBirthday(parse);
            service.addStu(stu);
            resp.sendRedirect(req.getContextPath() + "/studentServlet?method=selectByPage&currentPage=" + currentPage + "&pageSize=" + pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        Page page = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        PageInfo info=new PageInfo(page);
        try {
            String json = new ObjectMapper().writeValueAsString(info);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
