package ru.geekbrains.JavaOne.lesson6.animals;

public class Animal {

    public String name;
    protected int runMax = 0;
    protected int swimmMax = 0;
    public int running;
    public int swimming;
    public static int countAnimals;

    public Animal(String name, int running, int swimming) {

        this.running = running;
        this.swimming = swimming;
        this.name = name;
        countAnimals++;

    }

    public void run(int running) {

        if (running <= runMax) System.out.printf("%s пробежал %d м.\n", name, running);
        else System.out.printf("%s может пробежать только %d м.\n", name, runMax);

    }

    public void swimm(int swimming) {

        if (swimming <= swimmMax) System.out.printf("%s проплыл %d м.\n", name, swimming);
        else System.out.printf("%s может проплыть только %d м.\n", name, swimmMax);

    }

}
