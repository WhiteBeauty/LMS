package com.company.view.student;

import com.company.modal.Course;
import com.company.modal.Enrollment;
import com.company.modal.Student;


import javax.swing.*;
import java.awt.*;


public class GetStudentsFrame extends JFrame {
    public GetStudentsPanel panel;
    public GetStudentsFrame(Course course, boolean toEnroll){
        if (toEnroll){
            setTitle("Зачислить студента на курс: " + course.getTitle() + " " + course.getDescription());
        } else {
            setTitle("Студенты курса: " + course.getTitle() + " " + course.getDescription());
        }
        getContentPane().setBackground(Color.cyan);
        setSize(500, 500);
        setLocation(1920 / 2 - 250, 1080 / 2 - 250);
        setLayout(new FlowLayout());
        panel = new GetStudentsPanel(course, toEnroll);
        add(panel);
        if (toEnroll){
            JButton addButton = new JButton("Записать");
            addButton.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int id = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.table.removeRowSelectionInterval(rowIndex, rowIndex);
                panel.table.updateUI();
                new Enrollment(Student.getStudentById(id), course);

            });
            add(addButton);
        }

        setVisible(true);

    }
}
