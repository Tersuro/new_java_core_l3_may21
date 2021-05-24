package ru.geekbrains.homework1_generics;

import java.util.ArrayList;

public class Homework1 {

    public static void main(String[] args) {
        FruitBox<Apple> appleFruitBox = new FruitBox<>(new Apple(), new Apple());
        FruitBox<Orange> orangeFruitBox = new FruitBox<>(new Orange(), new Orange(), new Orange(), new Orange());

        System.out.println(appleFruitBox.compare(orangeFruitBox));
        System.out.println(appleFruitBox.getWeight());
        System.out.println(orangeFruitBox.getWeight());

        FruitBox<Apple> apples = new FruitBox<>(new Apple(), new Apple(), new Apple());
        apples.transferAll(appleFruitBox);
        System.out.println(appleFruitBox.getWeight());

    }

    public static void replaceTwoElements(Object[] arr, int e1, int e2) {
        Object temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }

    public static <L> ArrayList<L> arrToList(L[] arr) {
        ArrayList<L> result = new ArrayList<L>(arr.length);
        for(L l : arr) {
            result.add(l);
        }
        return result;
    }
}
