package ru.geekbrains.java_two.lesson3_phone_directory;

import java.util.Map;

public class ThirdLesson {

    public static void main(String[] args) {

        UniqueSurnames.uniqueSurnames();

        PhoneDirectory pd = new PhoneDirectory();
        pd.add("Семенов", 89259886598L);
        pd.add("Сидоров", 89257588658L);
        pd.add("Павлов", 89258851278L);
        pd.add("Семенов", 89251285748L);
        pd.add("Сидоров", 89275857177L);
        pd.add("Максимова", 89228878582L);
        pd.add("Федоренко", 89278789625L);
        pd.add("Пугачева", 89247885477L);
        pd.add("Семенов", 89278524778L);

        for (Map.Entry<String, PhoneNumber> m: pd.phoneDirectory.entrySet()){
            pd.get(m.getKey());
        }

        if (!pd.get("Петренко")) System.out.println("В справочнике нет контакта с фамилией " + "Петренко");
    }

}
