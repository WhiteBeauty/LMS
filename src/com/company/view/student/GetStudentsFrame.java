package com.company.view.student;

import com.company.modal.Course;
import com.company.modal.Enrollment;
import com.company.modal.Student;
import com.company.repository.EnrollmentRepository;


import javax.swing.*;
import java.awt.*;


public class GetStudentsFrame extends JFrame {
    public GetStudentsPanel panel;
    public GetStudentsFrame(Course course, boolean toEnroll) {
        if (toEnroll) {
            setTitle("Зачислить студента на курс: " + course.getTitle() + " " + course.getDescription());
        } else {
            setTitle("Студенты курса: " + course.getTitle() + " " + course.getDescription());
        }
        getContentPane().setBackground(Color.cyan);
        setSize(500, 500);
        setLocation(1920 / 2 - 250, 1080 / 2 - 250);
        setLayout(new FlowLayout());
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        add(panel);
        JButton button = new JButton();

        if (toEnroll) {
            button.setText("Записать");
            button.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int id = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.model.removeRow(rowIndex);
                new Enrollment(Student.getStudentById(id), course);
            });
        } else {
            button.setText("Отчислить");
            button.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int studentId = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.model.removeRow(rowIndex);
                Enrollment enrollment = Enrollment.getEnrollment(Student.getStudentById(studentId), course);
                EnrollmentRepository.delete(enrollment.getId());
                Enrollment.remove(enrollment.getId());
            });
        }
        panel.add(button);
        pack();
        setVisible(true);
    }

    }