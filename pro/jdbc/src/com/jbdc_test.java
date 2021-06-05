package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jbdc_test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://txpan:3306/student","root","Pkl19980720");
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + resultSet.getString("name") + resultSet.getInt("age"));

            }
            con.close();
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
