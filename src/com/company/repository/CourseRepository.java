package com.company.repository;

import com.company.modal.Course;


import java.sql.*;

public class CourseRepository {
        private static final String url = "jdbc:postgresql://localhost:5432/lms1";
        private static final String user = "postgres";
        private static final String password = "123";
        public static void getAll() {
            try {
                // создаём соединение
                Connection conn = DriverManager.getConnection(url, user, password);

                // запустим соединение
                Statement statement = conn.createStatement();
                ResultSet results = statement.executeQuery("select * from course");

                while (results.next()){
                    String id = results.getString("id");
                    String title = results.getString("title");
                    String description = results.getString("description");
                    new Course(Integer.parseInt(id), title, description);
                }
                conn.close();
            } catch (Exception e){
                System.out.println("Не удалось подключиться к БД");
                System.out.println(e.getMessage());
            }
        }
    public static void add(int id, String title, String description) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement = conn.prepareStatement("insert into course (id, title, description) values(?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось добавить курс");
            System.out.println(e.getMessage());
        }
    }
    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            conn.createStatement().executeQuery("delete from course where (id =" + id + ")");
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить курс");
            System.out.println(e.getMessage());
        }
    }
    public static void update(int id, String title, String description) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement = conn.prepareStatement("update course " + "set title=?, description=?" + "where id=?");
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setInt(3, id);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось изменить курс");
            System.out.println(e.getMessage());
        }
    }
    }
