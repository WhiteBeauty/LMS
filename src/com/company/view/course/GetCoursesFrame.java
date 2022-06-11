package com.company.view.course;


import com.company.modal.Course;
import com.company.modal.Enrollment;
import com.company.modal.Student;
import com.company.repository.EnrollmentRepository;

import javax.swing.*;
import java.awt.*;


public class GetCoursesFrame extends JFrame {
public GetCoursesPanel panel;
    public GetCoursesFrame(Student student, boolean toEnroll){
        if (toEnroll){
            setTitle("Зачислить студента: " + student.getName() + " " + student.getSurname());
        } else {
     setTitle("Курсы студента: " + student.getName() + " " + student.getSurname());
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
                new Enrollment(student, Course.getCourseById(id));
            });
        } else {
            button.setText("Отчислить");
            button.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int courseId = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.model.removeRow(rowIndex);
                Enrollment enrollment = Enrollment.getEnrollment(student, Course.getCourseById(courseId));
                EnrollmentRepository.delete(enrollment.getId());
                Enrollment.remove(enrollment.getId());
            });
        }
        panel.add(button);
        pack();
        setVisible(true);

    }
}
