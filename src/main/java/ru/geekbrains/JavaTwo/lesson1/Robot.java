package ru.geekbrains.JavaTwo.lesson1;

public class Robot implements Moveable{

    private final String name;
    private final int runMax;
    private final int jumpMax;

    public Robot(String name, int runMax, int jumpMax) {
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
        return "Robot";
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
