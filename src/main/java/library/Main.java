package library;

import library.controller.AdminController;
import library.db.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {


    public static void main(String[] args) {
        Database.initAdmins();
        Database.createBookTable();
        Database.createStudentTable();
        Database.createStudentBookTable();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AdminController adminController = (AdminController) context.getBean("adminController");
        adminController.start();

    }
}
