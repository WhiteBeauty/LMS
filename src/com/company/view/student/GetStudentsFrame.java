package com.company.view.student;

import com.company.modal.Course;
import com.company.modal.Enrollment;
import com.company.modal.Student;



import javax.swing.*;
import java.awt.*;
import java.util.Objects;


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
        panel = new GetStudentsPanel(course, toEnroll);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        add(panel);
        JButton button = new JButton();
        if (toEnroll) {
            button.setText("Зачислить");
            button.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int student_id = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.model.removeRow(rowIndex);
                new Enrollment(Objects.requireNonNull(Student.getStudentById(student_id)), course);
            });
        } else {
            button.setText("Отчислить");
            button.addActionListener(e -> {
                int rowIndex = panel.table.getSelectedRow();
                int student_id = Integer.parseInt(panel.table.getValueAt(rowIndex, 0).toString());
                panel.model.removeRow(rowIndex);
                Enrollment enrollment = Enrollment.getEnrollment(Student.getStudentById(student_id), course);
                Enrollment.remove(enrollment.getId());
            });
        }
        panel.add(button);
        pack();
        setVisible(true);


    }
}
