package ru.geekbrains.java_one.lesson8;

import javax.swing.*;
import java.awt.*;

public class Notification extends JFrame {

    public Notification(String message) {
        super("Сообщение");
        createSettings(message);
    }

    private void createSettings(String message) {

        setSize(1000, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Calibri", Font.PLAIN, 30));
        textField.setHorizontalAlignment(0);
        textField.setText(message);
        add(textField, BorderLayout.CENTER);

        final JPanel panel = new JPanel();
        JButton okay = new JButton("Ок");
        okay.addActionListener(e -> {
            EighthLesson.decision = true;
            dispose();
        });
        okay.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(okay, new BoxLayout(this, BoxLayout.X_AXIS));
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

}
