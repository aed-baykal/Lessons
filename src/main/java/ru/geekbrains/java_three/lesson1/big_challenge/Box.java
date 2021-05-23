package ru.geekbrains.java_three.lesson1.big_challenge;

import java.util.ArrayList;

public class Box <N>{

    private N Fruit;
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

    public boolean compare(Box<Orange> box){
        return this.getWeight() == box.getWeight();
    }

    public boolean pourOverTheFruit(Box box){
        if (((this.fruits.get(0) instanceof Apple) && (box.fruits.get(0) instanceof Apple))
        || ((this.fruits.get(0) instanceof Orange) && (box.fruits.get(0) instanceof Orange))) {
            for (int i = (box.fruits.size()-1); i >=0 ; i--) {
                this.addFruit((N) box.fruits.get(i));
                removeFruit(box, (N) box.fruits.get(i));
            }
            return true;
        }else return false;
    }

}
