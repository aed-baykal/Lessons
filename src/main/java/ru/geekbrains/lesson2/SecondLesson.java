package ru.geekbrains.lesson2;

import java.util.Arrays;

public class SecondLesson {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] arr2 = new int[8];
        int[] arr3 = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr4 = new int[5][5];

        System.out.println("Массив на входе:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Массив на выходе:");
        System.out.println(Arrays.toString(invertTheArray(arr1)));

        System.out.println("Массив на входе:");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Массив на выходе:");
        System.out.println(Arrays.toString(fillArray(arr2)));

        System.out.println("Массив на входе:");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Массив на выходе:");
        System.out.println(Arrays.toString(convertingAnArray(arr3)));

        System.out.println("Массив на входе:");
        printingATwoDimensionalArray(arr4);
        System.out.println("Массив на выходе:");
        printingATwoDimensionalArray(fillDiagonalElementsByOne(arr4));

        System.out.println("Массив на входе:");
        System.out.println(Arrays.toString(arr3));
        System.out.print("Минимальный элемент массива: ");
        System.out.println(minimumAndMaximumElements(arr3)[0]);
        System.out.print("Максимальный элемент массива: ");
        System.out.println(minimumAndMaximumElements(arr3)[1]);

        System.out.println("Результат сравнения правых и левых частей массива: "
                + isTheSumOfTheLeftAndRightPartsOfTheArrayIsEqual(arr3));

        System.out.println("Массив на входе:");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Массив на выходе: ");
        System.out.println(Arrays.toString(displaceAllArrayElements(arr3, 7)));

    }

    static int[] invertTheArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] - 1) * -1;
        }
        return arr;

    }

    static int[] fillArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        return arr;

    }

    static int[] convertingAnArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        return arr;

    }

    static int[][] fillDiagonalElementsByOne(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || (i + j + 1) == arr.length) arr[i][j] = 1;
            }
        }
        return arr;

    }

    static void printingATwoDimensionalArray(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static int[] minimumAndMaximumElements(int[] arr) {

        int[] minMax = {arr[0], arr[0]};

        for (int i : arr) {
            minMax[0] = Math.min(i, minMax[0]);
            minMax[1] = Math.max(i, minMax[1]);
        }
        return minMax;

    }

    static boolean isTheSumOfTheLeftAndRightPartsOfTheArrayIsEqual(int[] arr) {

        int summLeft = 0;
        int summRigtht = 0;

        for (int i : arr) {
            summRigtht = summRigtht + i;
        }
        for (int i : arr) {
            summLeft = summLeft + i;
            summRigtht = summRigtht - i;
            if (summLeft == summRigtht) return true;
        }
        return false;

    }

    public static int[] displaceAllArrayElements(int[] arr, int shift) {

        if (shift < 0) shift = arr.length + shift;
        while (shift > 0) {
            int lastVar = arr[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                int buffer = arr[i];
                arr[i] = lastVar;
                lastVar = buffer;
            }
            shift--;
        }
        return arr;
    }

}
