package ru.geekbrains.java_two.lesson2_exception;

public class MyArraySizeException extends Exception{

    public void printMessage() {
        System.out.println("Массив strings[][] не является массивом 4х4.");
    }

}

