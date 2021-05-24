package ru.geekbrains.java_three.lesson1.big_challenge;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        for (int i = 0; i < (new Random().nextInt(100)); i++) {
            appleBox1.addFruit(new Apple());
        }

        for (int i = 0; i < (new Random().nextInt(100)); i++) {
            appleBox2.addFruit(new Apple());
        }

        for (int i = 0; i < (new Random().nextInt(100)); i++) {
            orangeBox1.addFruit(new Orange());
        }

        for (int i = 0; i < (new Random().nextInt(100)); i++) {
            orangeBox2.addFruit(new Orange());
        }

        System.out.println("Вес коробки1: " + appleBox1.getWeight() + "  В нее положили: " + appleBox1.countFruit + " фруктов");
        System.out.println("Вес коробки2: " + appleBox2.getWeight() + "  В нее положили: " + appleBox2.countFruit + " фруктов");
        System.out.println("Вес коробки3: " + orangeBox1.getWeight()+ "  В нее положили: " + orangeBox1.countFruit + " фруктов");
        System.out.println("Вес коробки4: " + orangeBox2.getWeight()+ "  В нее положили: " + orangeBox2.countFruit + " фруктов");

        System.out.println("Вес коробок 1 и 4 равен 'true' или нет 'false': " + appleBox1.compare(orangeBox2));

        System.out.println("Вес коробки2: " + appleBox2.getWeight() + "  В нее положили: " + appleBox2.countFruit + " фруктов");
        System.out.println("Вес коробки3: " + orangeBox2.getWeight()+ "  В нее положили: " + orangeBox2.countFruit + " фруктов");
        appleBox1.pourOverTheFruit(appleBox2);
        System.out.println("Вес коробки1: " + appleBox1.getWeight() + "  В нее положили: " + appleBox1.countFruit + " фруктов");
        System.out.println("Вес коробки2: " + appleBox2.getWeight() + "  В нее положили: " + appleBox2.countFruit + " фруктов");

    }

}
