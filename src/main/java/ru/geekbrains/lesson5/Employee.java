package ru.geekbrains.lesson5;

public class Employee {

    protected String fullName;
    protected String position;
    protected String email;
    protected long phone;
    protected int salary;
    protected int age;

    public Employee(String fullName, String position, String email,
                    long phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "ФИО '" + fullName + '\'' +
                ", должность '" + position + '\'' +
                ", email '" + email + '\'' +
                ", телефон '" + phone + '\'' +
                ", зарплата '" + salary + '\'' +
                ", возраст '" + age + '\'' +
                '}';
    }
}
