package ru.geekbrains.homework7_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static ru.geekbrains.homework7_reflection.ReflectionTester.start;

public class MainClass {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(Testing.class);
    }
}
