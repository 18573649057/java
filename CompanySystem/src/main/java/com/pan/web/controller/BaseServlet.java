package com.pan.web.controller;

import com.pan.service.store.CompanyService;
import com.pan.service.store.Impl.CompanyServiceImpl;
import com.pan.service.store.Impl.UserServiceImpl;
import com.pan.service.store.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
    protected CompanyService companyService;
    //    protected DeptService deptService;
    protected UserService userService;
//    protected CourseService courseService;
//    protected CatalogService catalogService;
//    protected QuestionService questionService;
//    protected QuestionItemService questionItemService;
//    protected RoleService roleService;
//    protected ModuleService moduleService;

    @Override
    public void init() throws ServletException {
        companyService = new CompanyServiceImpl();
//        deptService = new DeptServiceImpl();
        userService = new UserServiceImpl();
//        courseService = new CourseServiceImpl();
//        catalogService = new CatalogServiceImpl();
//        questionService = new QuestionServiceImpl();
//        questionItemService = new QuestionItemServiceImpl();
//        roleService = new RoleServiceImpl();
//        moduleService = new ModuleServiceImpl();
    }

}
