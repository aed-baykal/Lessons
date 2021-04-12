package ru.geekbrains.lesson8;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    public SettingsWindow() {
        super("Крестики Нолики");
        createSettings();
    }

    public void createSettings() {

        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(2,1));
        final JTextField settings = new JTextField();
        settings.setEditable(false);
        rootPanel.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        settings.setFont(new Font("Calibri", Font.PLAIN, 50));
        settings.setHorizontalAlignment(0);
        settings.setText("Настройки");
        settings.setBackground(Color.GRAY);
        rootPanel.add(settings);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,0));
        rootPanel.add(panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,0));
        panel1.add(panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,0));
        panel2.add(panel3);
        JTextField sizeTextField = new JTextField();
        sizeTextField.setEditable(false);
        sizeTextField.setFont(new Font("Calibri", Font.PLAIN, 30));
        sizeTextField.setHorizontalAlignment(0);
        sizeTextField.setText("Введите размер поля ('3х3' или '5х5')\"");
        panel3.add(sizeTextField);
        ButtonGroup group1 = new ButtonGroup();
        JRadioButton a3x3RadioButton = new JRadioButton();
        a3x3RadioButton.doClick();
        EighthLesson.fieldSize = 3;
        a3x3RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a3x3RadioButton.isSelected()) EighthLesson.fieldSize = 3;
            }
        });
        a3x3RadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        a3x3RadioButton.setText("3x3");
        group1.add(a3x3RadioButton);
        panel3.add(a3x3RadioButton);
        JRadioButton a5x5RadioButton = new JRadioButton();
        a5x5RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a5x5RadioButton.isSelected()) EighthLesson.fieldSize = 5;
            }
        });
        a5x5RadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        a5x5RadioButton.setText("5x5");
        group1.add(a5x5RadioButton);
        panel3.add(a5x5RadioButton);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,0));
        panel2.add(panel4);
        JTextField playersTextField = new JTextField();
        playersTextField.setEditable(false);
        playersTextField.setFont(new Font("Calibri", Font.PLAIN, 30));
        playersTextField.setHorizontalAlignment(0);
        playersTextField.setText("Вы будете играть вдвоем или с соперником?");
        panel4.add(playersTextField);
        ButtonGroup group2 = new ButtonGroup();
        JRadioButton vsCompRadioButton = new JRadioButton();
        vsCompRadioButton.doClick();
        EighthLesson.gameType = 1;
        vsCompRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vsCompRadioButton.isSelected()) EighthLesson.gameType = 1;
            }
        });
        vsCompRadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        vsCompRadioButton.setText("Против компа");
        group2.add(vsCompRadioButton);
        panel4.add(vsCompRadioButton);
        JRadioButton a2PlayersRadioButton = new JRadioButton();
        a2PlayersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a2PlayersRadioButton.isSelected()) EighthLesson.gameType = 2;
            }
        });
        a2PlayersRadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
//        a5x5RadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        a2PlayersRadioButton.setText("2 Игрока");
        group2.add(a2PlayersRadioButton);
        panel4.add(a2PlayersRadioButton);
        JButton save = new JButton("Сохранить настройки");
        save.setFont(new Font("Calibri", Font.PLAIN, 20));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel4.add(save);
        add(rootPanel);

        setVisible(true);
    }
}
