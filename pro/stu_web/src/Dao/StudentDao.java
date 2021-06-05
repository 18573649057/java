package Dao;
import Bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /**
     * 添加
     * @param student
     */
    public   void  addStudent(Student student){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn =  DriverManager.getConnection("jdbc:mysql://txpan:3306/student","root","Pkl19980720");

            PreparedStatement preparedStatement = conn.prepareStatement("insert into student values(null ,?,?)");

            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        try {
            List<Student>  students = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn =  DriverManager.getConnection("jdbc:mysql://txpan:3306/student","root","Pkl19980720");

            PreparedStatement preparedStatement = conn.prepareStatement("select * from  student");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
            }

            return   students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
