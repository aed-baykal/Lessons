package ru.geekbrains.java_two.lesson5_threads;

import java.util.Arrays;

public class FifthLesson {

    final static int size = 10000000;
    final static int h = size / 2;
    static float[] arr1 = new float[size];
    static float[] arr2 = new float[size];
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];

    public static void main(String[] args) {
        System.out.println("Результат сравнения массивов, получившихся при их обработке " +
                "разными методами: " + Arrays.equals(fist(), second()));
    }

    private static float[] fist() {
        Arrays.fill(arr1, (float) 1.0);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Скорость выпонения первого метода: " + (System.currentTimeMillis() - a));
        return arr1;
    }

    private static float[] second() {
        Arrays.fill(arr2, (float) 1.0);
        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        Thread tr0 = new MyThread(h, a1, 0);
        tr0.start();
        Thread tr1 = new MyThread(h, a2, h);
        tr1.start();
        try {
            tr0.join();
            tr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        System.out.println("Скорость выпонения второго метода: " + (System.currentTimeMillis() - a));
        return arr2;
    }

}

    class MyThread extends Thread{

        final int size;
        final int offset;
        float[] arr;

        public MyThread(int size, float[] array, int offset) {
            this.size = size;
            this.arr = array;
            this.offset = offset;

        }

        @Override
        public void run() {
            for (int i = 0; i < size; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
            }
        }

    }