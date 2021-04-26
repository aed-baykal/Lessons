package ru.geekbrains.JavaOne.lesson6;

import ru.geekbrains.JavaOne.lesson6.animals.Animal;
import ru.geekbrains.JavaOne.lesson6.animals.Cat;
import ru.geekbrains.JavaOne.lesson6.animals.Dog;
import java.util.Scanner;

public class SixthLesson {

    static Scanner scanner = new Scanner(System.in);
    static Animal[] animals = new Animal[100];

    public static void main(String[] args) {

        for (Animal animal : animals) {
            System.out.print("Введите, какое животное вы хотите создать. 1- кошка, 2- собака, 3-выход >>>>");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Введите имя кошки, сколько она побежит и сколько проплывет >>>>");
                animal = new Cat(scanner.next(), scanner.nextInt(), scanner.nextInt());
                animal.run(animal.running);
                animal.swimm(animal.swimming);
            } else if (choice == 2) {
                System.out.print("Введите имя собаки, сколько она побежит и сколько проплывет >>>>");
                animal = new Dog(scanner.next(), scanner.nextInt(), scanner.nextInt());
                animal.run(animal.running);
                animal.swimm(animal.swimming);
            } else if (choice == 3) break;
            System.out.printf("Введенное количество животных = %d, из них кошек - %d, собак - %d\n",
                    Animal.countAnimals, Cat.countCats, Dog.countDogs);
        }

    }

}
