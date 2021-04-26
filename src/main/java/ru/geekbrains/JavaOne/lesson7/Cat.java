package ru.geekbrains.JavaOne.lesson7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean isTheCatFull(Bowl bowl) {
        if (bowl.getFullness() >= appetite) satiety = true;
        return satiety;
    }

    public void eat(Bowl bowl) {
        if (isTheCatFull(bowl)) bowl.reduceFullness(appetite);
    }

    @Override
    public String toString() {
        return name +
                " the cat has appetite " + appetite + ".";
    }
}
