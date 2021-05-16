package ru.geekbrains.java_two.lesson1_interface;

public class FirstLesson {
    public static void main(String[] args) {

        Moveable[] competingTeam = new Moveable[]{
                new Human("Mike", 1000, 100),
                new Human("Sasha", 1500, 150),
                new Cat("Barsick", 200, 120),
                new Cat("Mursick", 300, 130),
                new Robot("Verter", 10, 20),
                new Robot("R2D2", 2000, 20)
        };

        Passable[] obstacle = new Passable[]{
                new TreadMill(100),
                new TreadMill(1200),
                new Wall(20),
                new Wall(120)
        };

        for (Moveable moveable : competingTeam) {
            for (Passable passable : obstacle) {
                if (!moveable.passedTheTest(passable)) break;
            }
            System.out.println();
        }

    }
}
