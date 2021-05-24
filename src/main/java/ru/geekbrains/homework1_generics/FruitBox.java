package ru.geekbrains.homework1_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<F extends Fruit> {
    List<F> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }

    public FruitBox(F... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public FruitBox(List<F> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    public void add(F fruit) {
        this.fruits.add(fruit);
    }

    public double getWeight() {
//        if (this.fruits.size() == 0) return 0.0;
//        return this.fruits.size() * this.fruits.get(0).getWeight();
        double weight = 0.0;
        for (F fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(FruitBox<?> another) {
        return Math.abs(getWeight() - another.getWeight()) < 0.0001;
    }

    public void transferAll(FruitBox<F> another) {
        if (this == another) return;
        another.getFruits().addAll(fruits);
        fruits.clear();
    }

    public List<F> getFruits() {
        return fruits;
    }
}