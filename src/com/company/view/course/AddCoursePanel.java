package com.company.view.course;

import com.company.Main;
import com.company.modal.Course;

import javax.swing.*;
import java.awt.*;


public class AddCoursePanel extends JPanel {
    public AddCoursePanel(){

        setBackground(Color.GRAY);
        // Поля для ввода
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);
        JTextField teacher = new JTextField(10);
        // Компонент для отображения текста

        // Кнопка
        JButton addButton2 = new JButton("Добавить курс");
        // Если нажата кнопка:
        addButton2.addActionListener(e -> {
            if (!title.getText().isEmpty()) {
                new Course(title.getText(), description.getText(), teacher.getText());
                title.setText("");
                description.setText("");
                teacher.setText("");
                Main.addStudentFrame.setVisible(false);

            }

        });


        add(teacher);
        add(title);
        add(description);
        add(addButton2);

    }
}
