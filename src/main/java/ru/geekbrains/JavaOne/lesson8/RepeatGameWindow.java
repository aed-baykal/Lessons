package ru.geekbrains.JavaOne.lesson8;

import javax.swing.*;
import java.awt.*;

public class RepeatGameWindow extends JFrame {

    public RepeatGameWindow() {
        super("Выход");
        createSettings();
    }

    private void createSettings() {

        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Calibri", Font.PLAIN, 30));
        textField.setHorizontalAlignment(0);
        textField.setText("Хотите выйти из игры?");
        add(textField, BorderLayout.CENTER);

        final JPanel panel = new JPanel();
        JButton yes = new JButton("Да");
        yes.addActionListener(e -> {
            EighthLesson.decision = false;
            System.exit(0);
        });
        yes.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(yes, new BoxLayout(this, BoxLayout.X_AXIS));
        JButton no = new JButton("Нет");
        no.addActionListener(e -> {
                EighthLesson.decision = true;
                dispose();
        });
        no.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(no, new BoxLayout(this, BoxLayout.X_AXIS));
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

}
