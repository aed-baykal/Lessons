package ru.geekbrains.JavaTwo.lesson1;

public class Wall implements Passable{

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getDistance() {
        return 0;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
