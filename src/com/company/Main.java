package com.company;





import com.company.repository.Repository;
import com.company.view.MainFrame;

import com.company.view.course.AddCourseFrame;
import com.company.view.student.AddStudentFrame;

public class Main {

        public static MainFrame mainFrame = new MainFrame();
        public static AddStudentFrame addStudentFrame = new AddStudentFrame();
        public static AddCourseFrame addCourseFrame = new AddCourseFrame();
        public static Repository repository;
        public static void main(String[] args) {
            repository = new Repository("jdbc:postgresql://localhost:5432/lms1",
                    "postgres", "123");
        }
}