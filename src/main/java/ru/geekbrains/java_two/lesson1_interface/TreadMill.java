package ru.geekbrains.java_two.lesson1_interface;

public class TreadMill implements Passable{

    private final int distace;

    public TreadMill(int distace) {
        this.distace = distace;
    }

    @Override
    public int getDistance() {
        return distace;
    }

    @Override
    public int getHeight() {
        return 0;
    }

}
