package ru.geekbrains.JavaOne.lesson3;

import java.util.Random;
import java.util.Scanner;

public class ThirdLesson_1 {
    public static void main(String[] args) {

        guessTheNumber();

    }

    private static void guessTheNumber() {

        Scanner scanner = new Scanner(System.in);
        int decision;

        System.out.println("Вы запустили игру 'Угадай число от 0 до 9'");
        System.out.println("У вас будет три попытки.");
        do {
            initGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет» ");
            decision = scanner.nextInt();
        } while (decision != 0);

    }

    private static void initGame() {

        Random random = new Random();
        int hiddenNumber = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 4; i++) {
            int enteredNumber;
            do {
                System.out.println(i + "-ая попытка.");
                System.out.println("Введите число от 0 до 9 включительно: ");
                enteredNumber = scanner.nextInt();
                if (enteredNumber > 9 || enteredNumber < 0)
                    System.out.println("Вы ввели число, не входящее в указанный диапазон.");
            } while (enteredNumber > 9 || enteredNumber < 0);
            if (enteredNumber == hiddenNumber) {
                System.out.println("Поздравляем! Вы угадали!");
                break;
            } else if (enteredNumber > hiddenNumber)
                System.out.println("Введенное число больше загаданного.");
            else
                 System.out.println("Введенное число меньше загаданного.");

        }
        System.out.println("Игра окончена.");

    }

}
