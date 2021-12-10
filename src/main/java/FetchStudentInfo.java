import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchStudentInfo{
    public static Student searchStudent(int id) {
        Student student = new Student();
        try {
            // Initialize database connection and execute sql.
            Connection mysqlConnection = DatabaseConnection.initializeDatabase();
            PreparedStatement sqlStatement = mysqlConnection.prepareStatement("select * from student where id = ?");
            sqlStatement.setInt(1, id);
            ResultSet resultSet = sqlStatement.executeQuery();

            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                student.setPhone(resultSet.getString("phone"));
            }
            else return null;

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return student;
    }


    public static ArrayList<Student> getStudentInfo() {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            // Initialize database connection and execute sql.
            Connection mysqlConnection = DatabaseConnection.initializeDatabase();
            PreparedStatement sqlStatement = mysqlConnection.prepareStatement("select * from student");
            ResultSet resultSet = sqlStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                student.setPhone(resultSet.getString("phone"));
                studentList.add(student);
            }

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return studentList;
    }
}