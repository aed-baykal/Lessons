package ru.geekbrains.java_three.lesson5;

import static ru.geekbrains.java_three.lesson5.MainClass.*;

public class Car implements Runnable{
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");

            Thread.sleep(500 + (int)(Math.random() * 800));
            cyclicBarrier.await();
            System.out.println(this.name + " готов");
            cyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        cdlBegin.countDown();

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlFinish.countDown();
        if (cdlFinish.getCount() == (MainClass.CARS_COUNT - 1))
            System.out.println(this.name + " Win");
    }
}
