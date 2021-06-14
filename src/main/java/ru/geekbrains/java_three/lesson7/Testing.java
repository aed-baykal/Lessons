package ru.geekbrains.java_three.lesson7;

public class Testing {

    public static void method1(){
        System.out.println("Метод1");
    }

    @BeforeSuite
    public static void method2(){
        System.out.println("Метод2");
    }

    @AfeterSuite
    public static void method3(){
        System.out.println("Метод3");
    }

    @Test(prior = 3)
    public static void method4(){
        System.out.println("Метод4");
    }

    @Test(prior = 7)
    public static void method5(){
        System.out.println("Метод5");
    }

    @Test(prior = 10)
    public static void method6(){
        System.out.println("Метод6");
    }

    @Test()
    public static void method7(){
        System.out.println("Метод7");
    }

}
