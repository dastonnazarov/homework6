package library.service;

import library.controller.AdminController;
import library.controller.StudentController;
import library.db.Database;
import library.dto.Student;
import library.repository.StudentRepository;
import org.postgresql.gss.GSSOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private StudentController studentController;


    public void isAdminOrStudent(String phone) {
        //   Student exist = studentRepository.getStudentByPhone(phone.getPhone());
        Student exist = studentRepository.getStudentByPhone(phone);
        if (exist == null) {
            System.err.println("not found!!!");
        } else if (exist.getPhone().equals("4477")) {
            adminController.adminStart();
        } else {
            studentController.studentSectionMenu();
        }
    }


    public void addStudent(Student student) {
        Student exist = studentRepository.getStudentByPhone(student.getPhone());
        if (exist != null) {
            System.out.println("sorry that student already exist!!!");
            adminController.adminSectionMenu();

        } else {
            student.setCreatedDate(LocalDate.now());
            studentRepository.saveStudent(student);
            System.out.println("Student is create successfully");
        }

    }

    public void studentList() {
        System.out.println("----------   Student List ----------");
        List<Student> cards = studentRepository.getAllStudent();
        cards.forEach(student -> System.out.println(student));
        adminController.adminSectionMenu();
    }

    public void deleteStudent(Student student) {
      Student exist = studentRepository.getStudentById(student.getId());
      if(exist==null){
          System.out.println("Student doesn't find!!");
          adminController.adminSectionMenu();
          return;
      }else {
          studentRepository.deleteStudent(student.getId());
          System.out.println("student is successfully deleted");
          adminController.adminSectionMenu();
      }
    }

}


