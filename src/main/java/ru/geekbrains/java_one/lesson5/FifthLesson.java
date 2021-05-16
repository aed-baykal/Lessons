package ru.geekbrains.java_one.lesson5;

public class FifthLesson {
    public static void main(String[] args) {

        Employee[] staff = new Employee[5];
        staff[0] = new Employee("Левин Роман Викторович","ведущий инженер","levin@textil.ru", 89254141412L, 50000, 45);
        staff[1] = new Employee("Можаева Наталья Евгеньевна","секретарь","mogaeva@textil.ru", 89254141413L, 20000, 35);
        staff[2] = new Employee("Гусев Дмитрий Владимирович","менеджер","gusev@textil.ru", 89254141414L, 35000, 41);
        staff[3] = new Employee("Синявина Селена Вадимовна","сварщик","sinyavina@textil.ru", 89254141415L, 50000, 34);
        staff[4] = new Employee("Малькова Ольга Юрьевна","закройщик","malkova@textil.ru", 89254141416L, 30000, 55);

        for (Employee employee : staff) {
            if (employee.age > 40) System.out.println(employee.toString());
        }

    }

}
