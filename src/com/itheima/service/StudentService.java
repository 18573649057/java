package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.bean.Student;

public interface StudentService {
    public abstract Page selectByPage(Integer currentPage, Integer pageSize);

    public abstract void addStu(Student stu);

    public abstract void updateStu(Student stu);

    public abstract void deleteStu(String number);
}
