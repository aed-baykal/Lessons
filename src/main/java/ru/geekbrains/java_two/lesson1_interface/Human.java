package ru.geekbrains.java_two.lesson1_interface;

public class Human implements Moveable {

    private final String name;
    private final int runMax;
    private final int jumpMax;

    public Human(String name, int runMax, int jumpMax) {
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
        return "Human";
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
