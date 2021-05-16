package ru.geekbrains.java_two.lesson2_exception;

public class MyArrayDataException extends NumberFormatException{

    int i, j;
    String string;

    public MyArrayDataException(String string, int i, int j) {
        this.i = i;
        this.j = j;
        this.string = string;
    }

    public void printMessage() {
        System.out.printf("В ячейке массива strings[%d][%d] находится строка <<%s>> не являющаяся числом.\n", i, j, string);
    }

}
