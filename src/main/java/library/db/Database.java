package library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void createStudentTable() {
        try {
            String studentTable = "create table if not exists student( " +
                    "                id serial primary key, " +
                    "                name varchar(25) not null, " +
                    "                surname varchar(25) not null, " +
                    "                phone varchar(13) , " +
                    "                createdDate timestamp," +
                    "                role varchar default 'STUDENT'," +
                    "                visible boolean default 'true'" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(studentTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createBookTable() {
        try {
            String bookTable = "create table if not exists book( " +
                    "                id serial primary key, " +
                    "                title varchar not null, " +
                    "                author varchar  not null, " +
                    "                publishYear varchar default 'BLOCK', " +
                    "                amount real," +
                    "                visible boolean default true" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(bookTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createStudentBookTable() {
        try {
            String studentBookTable = "create table if not exists studentBook( " +
                    "                id serial primary key, " +
                    "                student_id Integer not null, " +
                    "                book_id Integer  not null, " +
                    "                createdDate timestamp, " +
                    "                status boolean," +
                    "                returnedDate timestamp," +
                    "                duration timestamp" +
                    "         );";

            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(studentBookTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initAdmins() {
        try {
            String profileTable = "insert into student(id,name,surname,phone,createdDate,role,visible) " +
                    "values('-1','admin','adminov','4477',now(),'ADMIN','true') ON CONFLICT (id) DO NOTHING;";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(profileTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            // 1
            Class.forName("org.postgresql.Driver");
            // 2-yo'l.
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/library", "postgres", "123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
