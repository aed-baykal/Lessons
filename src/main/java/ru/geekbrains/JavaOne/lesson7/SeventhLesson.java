package ru.geekbrains.JavaOne.lesson7;

public class SeventhLesson {

    public static Cat[] cats = new Cat[]{
            new Cat("Barsik", 35),
            new Cat("Murzik", 10),
            new Cat("Tina", 20),
            new Cat("Gosha", 50),
            new Cat("Pushistik", 40),
            new Cat("Sharik", 30)
    };
    public static Bowl bowl = new Bowl();

    public static void main(String[] args) {

        bowl.addFoodToTheBowl(100);
        for (Cat cat : cats) {
            System.out.printf("There is a %d of food in the bowl.\n", bowl.getFullness());
            System.out.println(cat.toString());
            cat.isTheCatFull(bowl);
            cat.eat(bowl);
            if (cat.isTheCatFull(bowl)) System.out.println(cat.getName() +
                    " the cat ate from a bowl and was full.");
            else System.out.println(cat.getName() + " the cat didn't have enough food " +
                    "in the bowl and he didn't eat it.");
        }

    }
}
