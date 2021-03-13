package ru.geekbrains.lesson1;

public class FirstLesson {

    public static void main(String[] args) {

        int a = 20;
        int b = 30;
        int c = -25;
        int d = 35;
        float result;
        boolean check;
        String name = "Андрей";
        int year = 2021;

        result = evaluatingAnExpression(a, b, c, d);
        System.out.println("Результат вычисления выражения равен " + result);

        check = checkingTheAmount(a, b);
        System.out.println("Результат проверки утверждения, " +
                "что a + b лежит в пределах от 10 до 20 (включительно) равен " + check);

        checkingTheNumber(c);

        welcomeMessage(name);

        isTheYearALeapYear(year);
    }

    static float evaluatingAnExpression (int a, int b, int c, int d) {
        return a * (b + (1.0f*c / d));
    }

    static boolean checkingTheAmount(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    static void checkingTheNumber (int c) {

        if (c < 0) {
            System.out.println("Введенное число меньше 0");
        } else {
            System.out.println("Введенное число больше или равно 0");
        }

    }

    static void welcomeMessage (String name) {
        System.out.println("Привет, " + name + "!");
    }

    static void isTheYearALeapYear (int year) {

            if (year%100 !=0 && year%4 == 0) {
                System.out.println("Год " + year + " является високосным.");
            } else if (year%400 == 0) {
                    System.out.println("Год " + year + " является високосным.");
            } else {
                System.out.println("Год " + year + " не является високосным.");
            }

    }
}
