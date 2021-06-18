package com.pan.service;

import com.github.pagehelper.Page;
import com.pan.bean.Student;

import java.io.IOException;

/*
    学生业务层接口
 */
public interface StudentService {
    /*
        分页查询方法
     */
    public abstract Page selectByPage(Integer currentPage, Integer pageSize) throws IOException;

    /*
        添加数据方法
     */
    public abstract void addStu(Student stu) throws IOException;

    /*
        修改数据方法
     */
    public abstract void updateStu(Student stu);

    /*
        删除数据方法
     */
    public abstract void deleteStu(String number);
}
