package com.pan.controller;

import com.pan.domain.Admin;
import com.pan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminCotroller {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String name,String pwd){
        System.out.println(name + pwd);
        int i = 0;
        List<Admin> all = adminService.findAll();
        if (all.size() != 0) {
            for (Admin admin : all) {
                String username = admin.getUsername();
                String password = admin.getPassword();
                if (username.equals(name) || password.equals(pwd)){
                    i=1;
                }
            }
        }
        if (i!=0){
            return "success.jsp";
        }
        return "error.jsp";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Admin> all = adminService.findAll();
        model.addAttribute("all",all);
        return "success.jsp";
    }
    @RequestMapping("/update")
    public String update(Admin admin){
        adminService.update(admin);
        return "success.jsp";
    }
    @RequestMapping("/delete")
    public String delete(Admin admin){
        String username = admin.getUsername();
        adminService.delete(username);
        return "success.jsp";
    }
    @RequestMapping("/save")
    public String save(Admin admin){
        adminService.save(admin);
        return "success.jsp";
    }
}
