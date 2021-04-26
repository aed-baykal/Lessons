package ru.geekbrains.JavaOne.lesson6.animals;

public class Cat extends Animal {

    protected final int RUN_MAX = 200;
    public static int countCats;

    public Cat(String name, int running, int swimming) {

        super(name, running, swimming);
        super.runMax = this.RUN_MAX;
        countCats++;

    }

    @Override
    public void swimm(int obstacleLength) {

        System.out.printf("%s не умеет плавать\n", name);

    }

}
