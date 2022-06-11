package com.company.repository;


import com.company.modal.Enrollment;

import java.sql.*;

public class EnrollmentRepository {
    private static final String url = "jdbc:postgresql://localhost:5432/lms1";
    private static final String user = "postgres";
    private static final String password = "123";


    public static void getAll() {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("select * from enrollment");

            while (results.next()) {
                int id = Integer.parseInt(results.getString("id"));
                int studentId = Integer.parseInt(results.getString("student_id"));
                int courseId = Integer.parseInt(results.getString("course_id"));
                new Enrollment(id, studentId, courseId);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
    }

    public static void add(int id, int studentId, int courseId) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement = conn.prepareStatement("insert into enrollment (id, student_id, course_id) values(?, ?, ?)");
            statement.setInt(1, id);
            statement.setInt(2, studentId);
            statement.setInt(3, courseId);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось добавить запись");
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            conn.createStatement().executeUpdate("delete from enrollment where (id =" + id + ")");
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось удалить запись");
            System.out.println(e.getMessage());
        }
    }

    public static void update(int id, int studentId, int courseId) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement = conn.prepareStatement("update enrollment " + "set studentId=?, courseId=?" + "where id=?");
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setInt(3, id);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Не удалось изменить студента");
            System.out.println(e.getMessage());
        }
    }
}

