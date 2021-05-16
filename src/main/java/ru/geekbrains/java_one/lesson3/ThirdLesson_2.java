package ru.geekbrains.java_one.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ThirdLesson_2 {
    public static void main(String[] args) {

        guessTheWord();

    }

    static void guessTheWord() {

        Scanner scanner = new Scanner(System.in);
        int decision;

        System.out.println("Вы запустили игру 'Угадай слово.'");
        do {
            initGame();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет» ");
            decision = scanner.nextInt();
        } while (decision != 0);

    }

    static void initGame(){

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        String answer;
        char[] hiddenWordByChar;
        boolean failure;
        Random random = new Random();
        char[] printHiddenWordByChar = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        hiddenWordByChar = words[random.nextInt(25)].toCharArray();
        do {
            failure = true;
            StringBuilder hiddenWord = new StringBuilder();

            System.out.println("Введите слово.");
            answer = scanner.next().toLowerCase();
            for (char c : hiddenWordByChar) hiddenWord.append(c);
                if (answer.equals(hiddenWord.toString())) {
                    System.out.println("Вы угадали!");
                    failure = false;
                } else System.out.println("Не угадали. Попробуйте еще раз.");
            System.out.println(Arrays.toString(printTheGuessedCharacters(answer, hiddenWordByChar, printHiddenWordByChar)));
        } while (failure);
    }
    
    static char[] printTheGuessedCharacters(String answer, char[] hiddenWordByChar, char[] printHiddenWordByChar) {

        for (int j = 0; j < hiddenWordByChar.length; j++){
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == hiddenWordByChar[j]) {
                    printHiddenWordByChar[j] = hiddenWordByChar[j];
                    break;
                }
            }
        }
        return printHiddenWordByChar;
    }

}
