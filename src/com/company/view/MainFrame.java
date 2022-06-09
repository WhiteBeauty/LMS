package com.company.view;


import com.company.view.course.CourseListPanel;
import com.company.view.student.StudentListPanel;

import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame{
    Color[] colors = new Color[] {Color.GRAY, Color.CYAN, Color.PINK, Color.LIGHT_GRAY, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE};
    private int colorIndex = 0;
    public static StudentListPanel studentsPanel = new StudentListPanel();
    public static CourseListPanel coursePanel = new CourseListPanel();
    public MainFrame() {
        setTitle("LMS");
        setJMenuBar(new MainMenu());
        getContentPane().setBackground(colors[colorIndex]);
        setSize(500, 500);
        setLocation(710, 290);
        setLayout(new FlowLayout());
        add(studentsPanel);
        setVisible(true);
    }

    public void changeColor() {
        colorIndex = (colorIndex + 1) % colors.length;
        getContentPane().setBackground(colors[colorIndex]);

    }
    public void showCourses(){
        remove(studentsPanel);
        add(coursePanel);
        pack();
    }
    public void showStudents(){
        remove(coursePanel);
        add(studentsPanel);
        pack();
    }
}

