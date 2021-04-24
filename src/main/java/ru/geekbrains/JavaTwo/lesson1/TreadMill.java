package ru.geekbrains.JavaTwo.lesson1;

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
