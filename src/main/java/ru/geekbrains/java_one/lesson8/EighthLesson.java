package ru.geekbrains.java_one.lesson8;

public class EighthLesson {

    public static final char DOT_PLAYER = 'X';
    public static final char DOT_COMP = '0';
    public static final char DOT_EMPTY = ' ';
    public static final char[][] FIELD = new char[5][5];
    private static int theSameInTheLineMax;
    public static int fieldSize;
    public static int gameType;
    public static boolean decision = true;
    public static boolean firstPlayer;

    public static void main(String[] args) throws InterruptedException {

        gameTicTac();

    }

    public static void gameTicTac() throws InterruptedException {

        do {

            SettingsWindow sWindow = new SettingsWindow();
            while (sWindow.isVisible()) Thread.sleep(1000);

            if (fieldSize == 3) theSameInTheLineMax = fieldSize;
            else theSameInTheLineMax = fieldSize - 1;

            initfield();
            GameWindows gameWindows = new GameWindows(fieldSize);
            initGame(gameWindows, gameType);

            RepeatGameWindow repeatGameWindow = new RepeatGameWindow();
            while (repeatGameWindow.isVisible()) Thread.sleep(1000);
            gameWindows.dispose();
        } while (decision);

    }

    static void initGame(GameWindows gameWindows, int gameType) throws InterruptedException {
        firstPlayer = true;

        while (true) {
            while (!GameWindows.makeTurn) Thread.sleep(100);
            GameWindows.makeTurn = false;
            if (gameType == 2) firstPlayer = !firstPlayer;
            if (responseProcessing(DOT_PLAYER)) {   // Проверка на победу игрока
                if (gameType == 1) new Notification("Игра окончена. Поздравляю, вы победили!");
                else new Notification("Игра окончена. Поздравляю, первый игрок победил!");
                break;
            }
            if (gameType == 1) workingOutANewMove();                   // Ход компа. НОУ ХАУ :)
            if (responseProcessing(DOT_COMP)) {     // Проверка напобеду компа
                if (gameType == 1) new Notification("Игра окончена. Компьютер выиграл.");
                else new Notification("Игра окончена. Поздравляю, второй игрок победил!");
                break;
            }

            if (isThereADraw()) {                   // Проверка на ничью
                new Notification("Игра окончена. Ничья.");
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

    private static boolean responseProcessing(char winner) {

        for (int y = 0; y < fieldSize; y++) {          //Пройти всю
            for (int x = 0; x < fieldSize; x++) {      //матрицу

                if (FIELD[y][x] == winner) {           //Если ячейка заполнена проверяемым игроком,
                                                       // то проверяем соседние на заполненность до theSameInTheLineMax(выигрышного кол-ва в линии)
                    if (horizontal(winner, y, x, theSameInTheLineMax)) return true;
                    if (vertical(winner, y, x, theSameInTheLineMax)) return true;
                    if (diagonal1(winner, y, x, theSameInTheLineMax)) return true;
                    if (diagonal2(winner, y, x, theSameInTheLineMax)) return true;

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

    private static boolean diagonal2(char winner, int y, int x, int theSameInTheLineMax) {     // Проверка одних диагоналей на заданное повторение одинаковых символов

        int theSameInTheLine = 0;
        for (int diagonal2 = y; diagonal2 >= 0; diagonal2--) {
            if ((fieldSize - 1 - diagonal2 + x) < fieldSize) {
                if (FIELD[diagonal2][fieldSize - 1 - diagonal2 + x] == winner) theSameInTheLine++;
                if (theSameInTheLine == theSameInTheLineMax) return true;
            }
        }
        return false;

    }

    private static boolean diagonal1(char winner, int y, int x, int theSameInTheLineMax) {     // Проверка других диагоналей на заданное повторение одинаковых символов

        int theSameInTheLine = 0;
        for (int diagonal1 = y; diagonal1 < fieldSize; diagonal1++) {
            if ((diagonal1 + x) < fieldSize) {
                if (FIELD[diagonal1][diagonal1 + x] == winner) theSameInTheLine++;
                if (theSameInTheLine == theSameInTheLineMax) return true;
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
                                GameWindows.buttons[y - 1][x].setText(String.valueOf(FIELD[y - 1][x]));
                                wasThereADangerous = true;
                                break;
                            } else if ((y + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y + theSameInTheLineMaxDangerous][x] != DOT_COMP && FIELD[y + theSameInTheLineMaxDangerous][x] != DOT_PLAYER) {
                                FIELD[y + theSameInTheLineMaxDangerous][x] = DOT_COMP;
                                GameWindows.buttons[y + theSameInTheLineMaxDangerous][x].setText(String.valueOf(FIELD[y + theSameInTheLineMaxDangerous][x]));
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (horizontal(DOT_PLAYER, y, x, theSameInTheLineMaxDangerous)) {
                            if ((x - 1) >= 0 && FIELD[y][x - 1] != DOT_COMP && FIELD[y][x - 1] != DOT_PLAYER) {
                                FIELD[y][x - 1] = DOT_COMP;
                                GameWindows.buttons[y][x - 1].setText(String.valueOf(FIELD[y][x - 1]));
                                wasThereADangerous = true;
                                break;
                            } else if ((x + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y][x + theSameInTheLineMaxDangerous] != DOT_COMP && FIELD[y][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                GameWindows.buttons[y][x + theSameInTheLineMaxDangerous].setText(String.valueOf(FIELD[y][x + theSameInTheLineMaxDangerous]));
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (diagonal1(DOT_PLAYER, y, x, theSameInTheLineMaxDangerous)) {
                            if ((x - 1) >= 0 && (y - 1) >= 0 && FIELD[y - 1][x - 1] != DOT_COMP && FIELD[y - 1][x - 1] != DOT_PLAYER) {
                                FIELD[y - 1][x - 1] = DOT_COMP;
                                GameWindows.buttons[y - 1][x - 1].setText(String.valueOf(FIELD[y - 1][x - 1]));
                                wasThereADangerous = true;
                                break;
                            } else if ((x + theSameInTheLineMaxDangerous) < fieldSize && (y + theSameInTheLineMaxDangerous) < fieldSize && FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_COMP
                                    && FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                GameWindows.buttons[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous].setText(String.valueOf(FIELD[y + theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous]));
                                wasThereADangerous = true;
                                break;
                            }
                        }
                        if (diagonal2(DOT_PLAYER, y, x, theSameInTheLineMaxDangerous)) {
                            if ((x + theSameInTheLineMaxDangerous) < fieldSize && (y - theSameInTheLineMaxDangerous) >= 0 && FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_COMP
                                    && FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] != DOT_PLAYER) {
                                FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous] = DOT_COMP;
                                GameWindows.buttons[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous].setText(String.valueOf(FIELD[y - theSameInTheLineMaxDangerous][x + theSameInTheLineMaxDangerous]));
                                wasThereADangerous = true;
                                break;
                            } else if ((x - 1) >= 0 && (y + 1) < fieldSize && FIELD[y + 1][x - 1] != DOT_COMP && FIELD[y + 1][x - 1] != DOT_PLAYER) {
                                FIELD[y + 1][x - 1] = DOT_COMP;
                                GameWindows.buttons[y + 1][x - 1].setText(String.valueOf(FIELD[y + 1][x - 1]));
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
