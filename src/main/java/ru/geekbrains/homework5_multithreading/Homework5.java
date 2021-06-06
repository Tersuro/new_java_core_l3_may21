package ru.geekbrains.homework5_multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Homework5 {
    public static final int CARS_COUNT = 4;
    public static final CyclicBarrier BARRIER = new CyclicBarrier(CARS_COUNT + 1);

    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        race.startRace(CARS_COUNT, BARRIER, race);
    }
}
