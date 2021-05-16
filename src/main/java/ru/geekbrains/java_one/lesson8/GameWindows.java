package ru.geekbrains.java_one.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindows extends JFrame {

    public static JButton[][] buttons = new JButton[5][5];
    public static boolean makeTurn = false;

    public GameWindows(int fieldSize) {
        super("Игра");
        createUIOfTheGame(fieldSize);
    }

    public void createUIOfTheGame(int fieldSize) {

        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new GridLayout(fieldSize, fieldSize));
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {

                buttons[i][j] = new JButton(String.valueOf(EighthLesson.FIELD[i][j]));
                buttons[i][j].setFont(new Font("Calibri", Font.PLAIN, (800 / fieldSize)));
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if ((EighthLesson.FIELD[finalI][finalJ] != EighthLesson.DOT_COMP)
                                && (EighthLesson.FIELD[finalI][finalJ] != EighthLesson.DOT_PLAYER)) {
                            if (EighthLesson.gameType == 1) {
                                EighthLesson.FIELD[finalI][finalJ] = EighthLesson.DOT_PLAYER;
                                buttons[finalI][finalJ].setText(String.valueOf(EighthLesson.FIELD[finalI][finalJ]));
                                makeTurn = true;
                            } else if (EighthLesson.firstPlayer){
                                EighthLesson.FIELD[finalI][finalJ] = EighthLesson.DOT_PLAYER;
                                buttons[finalI][finalJ].setText(String.valueOf(EighthLesson.FIELD[finalI][finalJ]));
                                makeTurn = true;
                            } else {
                                EighthLesson.FIELD[finalI][finalJ] = EighthLesson.DOT_COMP;
                                buttons[finalI][finalJ].setText(String.valueOf(EighthLesson.FIELD[finalI][finalJ]));
                                makeTurn = true;
                            }
                        }
                    }
                });
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

}
