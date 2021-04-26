package ru.geekbrains.JavaTwo.lesson2;

public class SecondLesson {

    private static String[][] strings = new String[][]{
            {"12", "33", "oops", "456"},
            {"65", "23,./", "87", "35"},
            {"098", "35637", "null", "352"},
            {"1", "2", "3", "4"}
    };
    private static int result = 0;

    public static void main(String[] args) {
        for (String[] string : strings) {
            for (String s : string) {
                System.out.print(s + " ");
            }
            System.out.println(" ");
        }
        try {
            System.out.println("Сумма всех чисел в массиве strings равна " + test());
        } catch (MyArraySizeException e) {
            e.printMessage();
        }
    }

    static int test() throws MyArraySizeException {
        if (strings.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(strings[j].length != 4) throw new MyArraySizeException();
                try {
                    try {
                        result += Integer.parseInt(strings[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(strings[i][j], i, j);
                    }
                } catch (MyArrayDataException e) {
                    e.printMessage();
                }
            }
        }
        return result;
    }

}
