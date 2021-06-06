package ru.geekbrains.homework5_multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private ArrayList<Stage> stages;
    private Object mon;
    public ArrayList<Stage> getStages() { return stages; }

    public Object getMon() {
        return mon;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.mon = new Object();
    }

    public void startRace(int CARS_COUNT, CyclicBarrier BARRIER, Race race) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            while (BARRIER.getNumberWaiting() != CARS_COUNT) {
                Thread.sleep(50);
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            BARRIER.await();

            while (BARRIER.getNumberWaiting() != CARS_COUNT) {
                Thread.sleep(50);
            }

            BARRIER.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
