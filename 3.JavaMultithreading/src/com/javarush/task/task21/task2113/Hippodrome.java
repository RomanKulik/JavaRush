package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //printWinner();
    }

    public void move() {
        for (Horse h : getHorses()) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : getHorses()) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        /*// var 1
        Horse horseResult = getHorses().get(0);
        for (int i = 1; i < getHorses().size(); i++) {
            if (horseResult.getDistance() < getHorses().get(i).getDistance()){
                horseResult = getHorses().get(i);
            }
        }

        return horseResult;

        // var 2
        return Collections.max(getHorses(), new Comparator<Horse>() {
                    @Override
                    public int compare(Horse o1, Horse o2) {
                        return (int)o1.getDistance() - (int)o2.getDistance();
                    }
                }
        );

        // var 3
        return Collections.max(getHorses(),
                (o1, o2) -> (int)o1.getDistance() - (int)o2.getDistance());*/

        // var 4
        return Collections.max(getHorses(),
                Comparator.comparingInt(o -> (int) o.getDistance()));
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
      /*  List<Horse> horses = new ArrayList<>();
        Collections.addAll(new ArrayList<>(), new Horse("horse1", 3, 0),
                new Horse("horse2", 3, 0),
                new Horse("horse3", 3, 0));*/
        game = new Hippodrome(new ArrayList<Horse>() {{
            add(new Horse("h1", 3, 0));
            add(new Horse("h2", 3, 0));
            add(new Horse("h3", 3, 0));
        }});

        game.run();
        game.printWinner();

    }
}
