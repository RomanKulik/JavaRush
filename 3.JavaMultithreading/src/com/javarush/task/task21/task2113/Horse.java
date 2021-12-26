package com.javarush.task.task21.task2113;

import java.util.Random;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse() {
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    // Randome()
    public void move() {
        // генерирует случайное значение в диапазоне [0,1).
        // Обратите внимание, что данный диапазон не включает 1
        // и при описании закрывается круглой скобкой.
        // double d = Math.random() * (max - min) + min;
        //distance += speed * Math.random() * (10 - 1) + 1;
        distance += speed * new Random().nextInt(10);
    }

    public void print() {
        for (int i = 0; i < (int) distance; i++) {
            System.out.print(".");
        }
        System.out.print(name);
        System.out.println();
    }
}
