import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tedt {
    public static void main(String[] args) throws Exception{

        ComboPooledDataSource com = new ComboPooledDataSource();

            Connection connection = com.getConnection();
            String sql = "SELECT * FROM student2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("sid")+","+resultSet.getString("name")+","+resultSet.getInt("age"+","+resultSet.getString("birthday")));
            }
            connection.close();
            resultSet.close();
            preparedStatement.close();


    }
}
