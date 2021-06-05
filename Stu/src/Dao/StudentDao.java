package Dao;

import Bean.Student;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class StudentDao {
    public static int add(Student student) {
        int result = 0;
        PreparedStatement statement = null;
        DataSource dataSource = null;
        Connection connection = null;
        try {
            InputStream is = StudentDao.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("insert into stu values (null ,'" + student.getName() + "','" + student.getAge() + "')");
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static ArrayList<Student> list() {
        ArrayList<Student> list = new ArrayList<>();
        Student student = new Student();
        PreparedStatement statement = null;
        DataSource dataSource = null;
        Connection connection = null;
        try {
            InputStream is = StudentDao.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * from stu");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student.setId(id);
                student.setName(name);
                student.setId(age);
                list.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}