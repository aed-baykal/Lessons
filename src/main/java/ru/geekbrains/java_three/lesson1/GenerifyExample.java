package ru.geekbrains.java_three.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GenerifyExample <T>{
    private T obj;

    public Object getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public ArrayList<T> convertsAnArray(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public ArrayList<T> swap(T[] arr, T obj1, T obj2) {
        ArrayList<T> swapArray = convertsAnArray(arr);
        Collections.swap(swapArray, swapArray.indexOf(obj1), swapArray.indexOf(obj2));
        return swapArray;
    }

}

