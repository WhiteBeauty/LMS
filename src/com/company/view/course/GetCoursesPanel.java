package com.company.view.course;

import com.company.modal.Course;
import com.company.modal.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GetCoursesPanel extends JPanel {
    public JTable table = new JTable();
    public DefaultTableModel model = new DefaultTableModel();
    public GetCoursesPanel(Student student, boolean toEnroll) {
       model.setColumnIdentifiers(new String[] { "ID", "Title", "Description"});

           for (Course course: student.getCourses(toEnroll)){
               model.addRow(new Object[]{course.getId(), course.getTitle(), course.getDescription()});
           }


            table.setModel(model);
            add(new JScrollPane(table));
    }
}
