package ru.geekbrains.JavaTwo.lesson5_threads;

import java.util.Arrays;

public class FifthLesson {

    final static int size = 10000000;
    final static int h = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    public static void main(String[] args) {
        System.out.println("Результат сравнения массивов, получившихся при их обработке " +
                "разными методами: " + Arrays.equals(fist(), second()));
    }

    private static float[] fist() {
        Arrays.fill(arr, (float) 1.0);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Скорость выпонения первого метода: " + (System.currentTimeMillis() - a));
        float[] arrFirst = arr;
        return arrFirst;
    }

    private static float[] second() {
        Arrays.fill(arr, (float) 1.0);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread tr0 = new MyThread(h, a1);
        tr0.start();
        Thread tr1 = new MyThread(h, a2);
        tr1.start();
        try {
            tr0.join();
            tr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Скорость выпонения второго метода: " + (System.currentTimeMillis() - a));
        return arr;
    }

}

    class MyThread extends Thread{

        final int size;
        float[] arr;

        public MyThread(int size, float[] array) {
            this.size = size;
            this.arr = array;
        }

        @Override
        public void run() {
            for (int i = 0; i < size; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

    }