package com.pan.Servlet;

import com.pan.Bean.Student;
import org.apache.ibatis.jdbc.SQL;

public class getsql {
    public static String getselect(Student student){
        return new SQL() {
            {
                SELECT("*");
                FROM("stu");
                if (student.getName()!=null){
                    WHERE("name=#{name}");
                }
                if (student.getAge()!=null){
                    AND();
                    WHERE("age=#{age}");
                }
            }
        }.toString();
    }
}
