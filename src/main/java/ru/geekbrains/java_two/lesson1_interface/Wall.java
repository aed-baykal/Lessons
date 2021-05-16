package ru.geekbrains.java_two.lesson1_interface;

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
