package com.pan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pan.bean.Student;
import com.pan.service.Impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {

    private StudentServiceImpl service = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求和响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getParameter("method");

        if (method.equals("selectByPage")){
            selectByPage(req,resp);
        }
        if (method.equals("addStu")){
            try {
                addStu(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void addStu(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Map<String, String[]> map = req.getParameterMap();
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        Student student = new Student();
        dateConvert();
        BeanUtils.populate(student,map);
        service.addStu(student);
        resp.sendRedirect(req.getContextPath()+ "/studentServlet?method=selectByPage&currentPage="+currentPage+"&pageSize="+pageSize);

    }

    //分页查询
    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        Page page = service.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        PageInfo  info = new PageInfo(page);
        String json = new ObjectMapper().writeValueAsString(info);
        resp.getWriter().write(json);
    }


    //添加


    private void dateConvert() {
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
