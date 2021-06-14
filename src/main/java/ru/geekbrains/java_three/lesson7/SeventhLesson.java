package ru.geekbrains.java_three.lesson7;

import java.lang.reflect.InvocationTargetException;

public class SeventhLesson {
    public static void main(String[] args) {
        try {
            Tester.start(Testing.class);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
