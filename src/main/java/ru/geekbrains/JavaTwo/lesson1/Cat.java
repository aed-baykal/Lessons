package ru.geekbrains.JavaTwo.lesson1;

public class Cat implements Moveable{

    private final String name;
    private final int runMax;
    private final int jumpMax;

    public Cat(String name, int runMax, int jumpMax) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public int getRunMax() {
        return runMax;
    }

    @Override
    public int getJumpMax() {
        return jumpMax;
    }

}
