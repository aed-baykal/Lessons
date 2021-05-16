package ru.geekbrains.java_one.lesson6.animals;

public class Dog extends Animal{

    protected final int RUN_MAX = 500;
    protected final int SWIMM_MAX = 10;
    public static int countDogs;

    public Dog(String name, int running, int swimming) {

        super(name, running, swimming);
        super.runMax = this.RUN_MAX;
        super.swimmMax = this.SWIMM_MAX;
        countDogs++;

    }
}
