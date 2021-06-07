package ru.geekbrains.java_three.lesson4;

public class FourthLesson {
    private volatile char letter = 'A';
    private final Object mon = new Object();

    public static void main(String[] args) {
        FourthLesson abc = new FourthLesson();
        new Thread(abc::printA).start();
        new Thread(abc::printB).start();
        new Thread(abc::printC).start();

    }

    private void printA() {
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC() {
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        mon.wait();
                    }
                    System.out.print(letter);
                    letter = 'C';
                    mon.notifyAll();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
