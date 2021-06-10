package com.pan.Servlet;

import com.pan.Bean.Student;
import com.pan.Dao.selectStudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectBy")
public class selectBy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getAttribute("name");
        Integer age = (Integer) req.getAttribute("age");
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        List<Student> stu = selectStudentDao.selectBy(student);
        Student s = new Student();
        for (Student student1 : stu) {
            s.setId(student1.getId());
            s.setName(student1.getName());
            s.setAge(student1.getAge());
        }

        req.setAttribute("s",s);
        req.getRequestDispatcher("show1.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
