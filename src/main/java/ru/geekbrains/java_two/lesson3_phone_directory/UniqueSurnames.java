package ru.geekbrains.java_two.lesson3_phone_directory;

import java.util.HashMap;
import java.util.Map;

public class UniqueSurnames {

    private static final String[] SURNAMES = new String[]{"Семенов", "Иванов", "Сидоров",
            "Семенов", "Петров", "Иванов", "Максимова", "Иванов", "Максимова", "Семенов",
            "Семенов", "Петров", "Иванов", "Максимова", "Иванов", "Максимова", "Семенов"
    };

    static void uniqueSurnames() {

        Map<String, Integer> unique = new HashMap<>();

        for (String surname : SURNAMES) {
            if (unique.containsKey(surname)) unique.put(surname, (1 +unique.get(surname)));
            else unique.put(surname, 1);
        }
        System.out.println(unique);

    }

}
