package com.company.view.student;

import com.company.Main;
import com.company.modal.Student;

import javax.swing.*;
import java.awt.*;

public class AddStudentPanel extends JPanel{
    public AddStudentPanel(){

        // Поля для ввода
        JTextField nameTF = new JTextField(10);
        JTextField surnameTF = new JTextField(10);
        // Компонент для отображения текста
        setBackground(Color.DARK_GRAY);
        // Кнопка
        JButton addButton = new JButton("Добавить студента");
        // Если нажата кнопка:
        addButton.addActionListener(e -> {
            if (!nameTF.getText().isEmpty() && !surnameTF.getText().isEmpty()) {
                new Student(nameTF.getText(), surnameTF.getText());
                nameTF.setText("");
                surnameTF.setText("");
                Main.addCourseFrame.setVisible(false);

            }

        });

        add(nameTF);
        add(surnameTF);
        add(addButton);

    }
}