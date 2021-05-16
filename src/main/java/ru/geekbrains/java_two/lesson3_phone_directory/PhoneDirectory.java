package ru.geekbrains.java_two.lesson3_phone_directory;

import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {

    public Map<String, PhoneNumber> phoneDirectory = new HashMap<>();

    public void add(String surname, Long number){
        if (phoneDirectory.containsKey(surname)) phoneDirectory.get(surname).addPhoneNumber(number);
        else phoneDirectory.put(surname, new PhoneNumber(number));
    }

    public boolean get(String surname){
        if (phoneDirectory.containsKey(surname)) {
            System.out.printf("В контакте %s записаны следующие номера:\n", surname);
            phoneDirectory.get(surname).printPhones();
            return true;
        } else return false;
    }
}
