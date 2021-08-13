package ru.geekbrains.java_three.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tester {

    static Method before = null;
    static Method after = null;

    public static void start(Class<?> c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = c.getDeclaredMethods();
        List<Method> methodsListToTest = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                if (method.getAnnotation(Test.class).prior() < 1 ||
                        method.getAnnotation(Test.class).prior() > 10)
                        throw new RuntimeException("Приоритет метода выходит за установленные границы (1-10)!");
                methodsListToTest.add(method);
            } else if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before != null) throw new RuntimeException("В классе обнаружена не уникальная аннотация BeforeSuite!");
                else before = method;
            } else if (method.isAnnotationPresent(AfeterSuite.class)) {
                if (after != null) throw new RuntimeException("В классе обнаружена не уникальная аннотация AfterSuite!");
                else after = method;
            }
        }
        Comparator<Method> comparator = new Comparator<>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).prior() - o1.getAnnotation(Test.class).prior();
            }
        };
        methodsListToTest.sort(comparator);
        if (before != null) methodsListToTest.add(0, before);
        if (after != null) methodsListToTest.add(after);
        for (Method method : methodsListToTest) {
            method.invoke(null);
        }
    }
}
