package ru.geekbrains.java_two.lesson3_phone_directory;

import java.util.ArrayList;

public class PhoneNumber {

    ArrayList<Long> phoneNumber = new ArrayList<>();

    public PhoneNumber(Long number) {
        this.phoneNumber.add(number);
    }

    public void addPhoneNumber(Long number) {
        phoneNumber.add(number);
    }

    public void printPhones() {
        for (Long l : phoneNumber) {
            System.out.println(l);
        }
    }
}
