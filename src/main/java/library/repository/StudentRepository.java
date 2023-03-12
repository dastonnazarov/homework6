package library.repository;

import library.db.Database;
import library.dto.Student;
import library.enums.StudentRole;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentRepository {

    public void saveStudent(Student student) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name,surname,phone,createdDate)values(?,?,?,now())");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPhone());
            int i = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new LinkedList<>();
        try {
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()) {
               Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                studentList.add(student);
            }
            connection.close();
            return studentList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public int deleteStudent(Integer id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id = ?");
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Student getStudentByPhone(String phone) {
        try {
            Student student = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where phone = ?");
            preparedStatement.setString(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone").trim());
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(resultSet.getBoolean("visible"));
            }
            connection.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(Integer id) {

        try {
            Student student = null;
            Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setPhone(resultSet.getString("phone"));
                student.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime().toLocalDate());
                student.setRole(StudentRole.valueOf(resultSet.getString("role")));
                student.setVisible(Boolean.valueOf(resultSet.getString("visible")));
            }
            connection.close();
            return student;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
