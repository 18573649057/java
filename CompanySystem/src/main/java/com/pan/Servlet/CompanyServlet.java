/*
package com.pan.Servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.bean.Company;
import com.pan.controller.Impl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CompanyServlet extends HttpServlet {
    private CompanyServiceImpl service = new CompanyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getParameter("method");
        //查询全部
        if (method.equals("findAll")){
            findAll(req,resp);
        }
        //删除
        if (method.equals("delete")){
            delete(req,resp);
        }
        //根据id查询
        if (method.equals("findById")){
            findById(req,resp);
        }
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("Id");
        service.findById(id);
        service.findAll();
    }

    //删除
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        Company company = new Company();
        //  获取传递进来的信息，将其传入对象
        service.delete(company);
        service.findAll();
    }

    //查询全部
    private void findAll(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List<Company> all = service.findAll();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(all);
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
*/
