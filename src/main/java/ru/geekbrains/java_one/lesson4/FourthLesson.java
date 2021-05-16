package ru.geekbrains.java_one.lesson4;

import java.util.Scanner;

public class FourthLesson {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char DOT_PLAYER = 'X';
    private static final char DOT_COMP = '0';
    private static final char DOT_EMPTY = '.';
    private static final char[][] FIELD = new char[5][5];
    private static int theSameInTheLineMax;
    private static int fieldSize;


    public static void main(String[] args) {

        gameTicTac();

    }

    static void gameTicTac() {

        Scanner scanner = new Scanner(System.in);
        int decision;

        System.out.println("Вы запустили игру 'Крестики Нолики.'");
        do {
            do {
                System.out.println("Введите размер поля ('3х3'- 3 или '5х5' - 5)");
                fieldSize = SCANNER.nextInt();
            } while (fieldSize != 3 && fieldSize != 5);
            if (fieldSize == 3) theSameInTheLineMax = fieldSize;
            else theSameInTheLineMax = fieldSize - 1;

            initfield();
            initGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет» ");
            decision = scanner.nextInt();
        } while (decision != 0);

    }

    static void initGame() {

        drawingThePlayingField();                   // Отрисовка поля
        while (true) {

            requestAPlayerHasMove();                // Ход игрока
            if (responseProcessing(DOT_PLAYER)) {   // Проверка на победу игрока
                drawingThePlayingField();
                System.out.println("Игра окончена. Поздравляю, вы выиграли!");
                break;
            }
            workingOutANewMove();                   // Ход компа. НОУ ХАУ :)
            drawingThePlayingField();
            if (responseProcessing(DOT_COMP)) {     // Проверка напобеду компа
                drawingThePlayingField();
                System.out.println("Игра окончена. Компьютер выиграл.");
                break;
            }
            if (isThereADraw()) {                   // Проверка на ничью
                System.out.println("Игра окончена. Ничья.");
                break;
            }

        }

    }

    static void initfield() {

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                FIELD[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void drawingThePlayingField() {

        System.out.print("   ");
        for (int i = 1; i <= fieldSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.println("  ---------");
            System.out.print(i + 1 + " |");
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(FIELD[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("  ---------");

    }

    private static void requestAPlayerHasMove() {

        int humanMoveX;
        int humanMoveY;

        do {
            System.out.print("Введите адрес вашей ячейки для Х (координаты x, y) >>>>");
            humanMoveX = SCANNER.nextInt() - 1;
            humanMoveY = SCANNER.nextInt() - 1;
        } while (humanMoveY < 0 || humanMoveY >= fieldSize || humanMoveX < 0
                || humanMoveX >= fieldSize || FIELD[humanMoveY][humanMoveX] == DOT_COMP
                || FIELD[humanMoveY][humanMoveX] == DOT_PLAYER);
        FIELD[humanMoveY][humanMoveX] = DOT_PLAYER;

    }

    private static boolean responseProcessing(char winner) {

        for (int y = 0; y < fieldSize; y++) {          //Пройти всю
            for (int x = 0; x < fieldSize; x++) {      //матрицу

                if (FIELD[y][x] == winner) {           //Если ячейка заполнена проверяемым игроком,
                                                       // то проверяем соседние на заполненность до theSameInTheLineMax(выигрышного кол-ва в линии)
                    if (horizontal(winner, y, x, theSameInTheLineMax)) return true;
                    if (vertical(winner, y, x, theSameInTheLineMax)) return true;
                    if (diagonal1(winner, y, theSameInTheLineMax)) return true;
                    if (diagonal2(winner, y, theSameInTheLineMax)) return true;

                }
            }
        }
        return false;

    }

    private static boolean isThereADraw() {

        for (int j = 0; j < fieldSize; j++) {
            for (char i : FIELD[j]) {
                if (i == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean diagonal2(char winner, int y, int theSameInTheLineMax) {     // Проверка одних диагоналей на заданное повторение одинаковых символов

        for (int diagonal2X = 0; diagonal2X < fieldSize; diagonal2X++) {
            int theSameInTheLine = 0;
            for (int diagonal2 = y; diagonal2 >= 0; diagonal2--) {
                if ((fieldSize - 1 - diagonal2 + diagonal2X) < fieldSize) {
                    if (FIELD[diagonal2][fieldSize - 1 - diagonal2 + diagonal2X] == winner) theSameInTheLine++;
                    if (theSameInTheLine == theSameInTheLineMax) return true;
                }
            }
        }
        return false;

    }

    private static boolean diagonal1(char winner, int y, int theSameInTheLineMax) {     // Проверка других диагоналей на заданное повторение одинаковых символов

        for (int diagonal1X = 0; diagonal1X < fieldSize; diagonal1X++) {
            int theSameInTheLine = 0;
            for (int diagonal1 = y; diagonal1 < fieldSize; diagonal1++) {
                if ((diagonal1 + diagonal1X) < fieldSize) {
                    if (FIELD[diagonal1][diagonal1 + diagonal1X] == winner) theSameInTheLine++;
                    if (theSameInTheLine == theSameInTheLineMax) return true;
                }
            }
        }
        return false;

    }

    private static boolean vertical(char winner, int y, int x, int theSameInTheLineMax) {       // Проверка на заданное повторение одинаковых символов по вертикали

        int theSameInTheLine = 0;

        for (int vertical = y; vertical < fieldSize; vertical++) {
            if (FIELD[vertical][x] == winner) theSameInTheLine ++;
            if (theSameInTheLine == theSameInTheLineMax) return true;
        }
        return false;

    }

    private static boolean horizontal(char winner, int y, int x, int theSameInTheLineMax) {     // Проверка на заданное повторение одинаковых символов по горизонтали

        int theSameInTheLine = 0;

        for (int horizontal = x; horizontal < fieldSize; horizontal++) {
            if (FIELD[y][horizontal] == winner) theSameInTheLine ++;
            if (theSameInTheLine == theSameInTheLineMax) return true;
        }
        return false;

    }

    private static void workingOutANewMove() {      // Проверка наличия нескольких символов игрока в ряд по всем направлениям от большего количества повторов

        boolean wasThereADangerous = false;         // до меньшего и подстановка символа компа (при возможности)в начале или конце этой линии.

        for (int theSameInTheLineMaxDangerous = (theSameInTheLineMax - 1); theSameInTheLineMaxDangerous >= 1; theSameInTheLineMaxDangerous --) {
            for (int y = 0; y < fieldSize; y++) {          //Пройти всю
                for (int x = 0; x < fieldSize; x++) {      //матрицу

                    if (FIELD[y][x] == DOT_PLAYER) {
                        if (vertical(DOT_PLAYER, y, x, theSameInTheLineMaxDangerous)) {
                            if ((y - 1) >= 0 && FIELD[y - 1][x] != DOT_COMP && FIELD[y - 1][x] != DOT_PLAYER) {
                                FIELD[y - 1][x] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            } else if ((y + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y + theSameInTheLineMaxDangerous][x] != DOT_COMP && FIELD[y + theSameInTheLineMaxDangerous][x] != DOT_PLAYER) {
                                FIELD[y + theSameInTheLineMaxDangerous][x] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (horizontal(DOT_PLAYER, y, x, theSameInTheLineMaxDangerous)) {
                            if ((x - 1) >= 0 && FIELD[y][x - 1] != DOT_COMP && FIELD[y][x - 1] != DOT_PLAYER) {
                                FIELD[y][x - 1] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            } else if ((x + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y][x + theSameInTheLineMaxDangerous] != DOT_COMP && FIELD[y][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (diagonal1(DOT_PLAYER, y, theSameInTheLineMaxDangerous)) {
                            if ((x - 1) >= 0 && (y - 1) >= 0 && FIELD[y - 1][x - 1] != DOT_COMP && FIELD[y - 1][x - 1] != DOT_PLAYER) {
                                FIELD[y - 1][x - 1] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            } else if ((x + theSameInTheLineMaxDangerous) < fieldSize && (y + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_COMP
                                    && FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (diagonal2(DOT_PLAYER, y, theSameInTheLineMaxDangerous)) {
                            if ((x + theSameInTheLineMaxDangerous) < fieldSize && (y - theSameInTheLineMaxDangerous) >= 0 && FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_COMP
                                    && FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            } else if ((x - 1) >= 0 && (y + 1) < fieldSize && FIELD[y + 1][x - 1] != DOT_COMP && FIELD[y + 1][x - 1] != DOT_PLAYER) {
                                FIELD[y + 1][x - 1] = DOT_COMP;
                                wasThereADangerous = true;
                                break;
                            }
                        }
                    }
                }
                if (wasThereADangerous) break;
            }
            if (wasThereADangerous) break;
        }

    }

}
