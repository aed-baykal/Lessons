package ru.geekbrains.java_three.lesson1.big_challenge;

import java.util.ArrayList;

public class Box <N>{

    public int countFruit = 0;
    private final ArrayList<N> fruits = new ArrayList<>();

    public void addFruit(N fruit) {
        this.fruits.add(fruit);
        this.countFruit++;
    }

    private void removeFruit(Box box, N fruit) {
        box.fruits.remove(fruit);
        box.countFruit--;
    }

    public float getWeight(){

        if (!fruits.isEmpty() && (fruits.get(0) instanceof Apple)) {
            return countFruit*Apple.WEIGHT;
        } else return countFruit*Orange.WEIGHT;

    }

    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }

    public void pourOverTheFruit(Box<N> box) {

        for (int i = (box.fruits.size() - 1); i >= 0; i--) {
            this.addFruit(box.fruits.get(i));
            removeFruit(box, box.fruits.get(i));
        }

    }

}
