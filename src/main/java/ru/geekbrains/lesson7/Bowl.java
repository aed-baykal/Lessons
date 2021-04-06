package ru.geekbrains.lesson7;

public class Bowl {

    private int fullness = 0;

    public void reduceFullness(int appetiteOfCat) {
        this.fullness -= appetiteOfCat;
    }

    public int getFullness() {
        return this.fullness;
    }

    public void addFoodToTheBowl(int fullness) {
        this.fullness += fullness;
    }
}
