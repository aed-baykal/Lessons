package ru.geekbrains.java_three.lesson1;

import java.util.ArrayList;

public class FirstLesson {

    private static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
            "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static final Integer[] NUM = {12, 346, 425, 7, 45, 25,67, 679, 235, 32};

    public static void main(String[] args) {

        GenerifyExample<String> newWords = new GenerifyExample<>();
        GenerifyExample<Integer> newNumber = new GenerifyExample<>();

        ArrayList<String> asListString = newWords.convertsAnArray(WORDS);
        ArrayList<Integer> asListInteger = newNumber.convertsAnArray(NUM);
        newWords.swap(WORDS, "apple", "pepper");
        newNumber.swap(NUM, 346, 25);

    }

}
