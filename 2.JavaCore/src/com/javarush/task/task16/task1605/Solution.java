package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке
Тяга к искусству есть даже у роботов-программистов!
Сегодня вот речь пойдёт о струнно-смычковых инструментах.
У нас есть класс скрипка (Violin).
Нужно его изменить так, чтобы он стал таском для нити.
Для этого используйте интерфейс MusicalInstrument.
А затем уже можно и "поиграть", и вывести продолжительность игры.

Поговорим о музыке
1. Измени класс Violin так, чтоб он стал таском для нити.
Используй интерфейс MusicalInstrument
2. Реализуй необходимый метод в нити Violin. Реализация должна быть следующей:
2.1. Считай время начала игры - метод startPlaying().
2.2. Подожди 1 секунду - метод sleepNSeconds(int n), где n - количество секунд.
2.3. Считай время окончания игры - метод stopPlaying().
2.4. Выведи на консоль продолжительность игры в миллисекундах.
Используй методы из пунктов 2.1 и 2.3.

Пример "Playing 1002 ms".


Требования:
1. Класс Violin не должен быть унаследован от какого-либо дополнительного класса.
2. Класс Violin должен реализовывать интерфейс MusicalInstrument.
3. Метод run класса Violin должен вызывать метод startPlaying.
4. Метод run класса Violin должен вызывать метод sleepNSeconds с параметром 1 секунда.
5. Метод run класса Violin должен вызывать метод stopPlaying.
6. Метод run класса Violin должен выводить на консоль
продолжительность игры в миллисекундах.
Используй формат из примера.
*/
public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        @Override
        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        @Override
        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }

        @Override
        public void run(){
            /*long d1 = this.startPlaying().getTime();
            sleepNSeconds(1);
            long d2 = this.stopPlaying().getTime();
            System.out.println(d2 - d1);*/
            //System.out.println(d2.getTime() - d1.getTime());
            /*System.out.println(this.owner + " played for " +
                    (d2.getTime() - d1.getTime()) +
                    " miliseconds");*/
            long st = startPlaying().getTime();
            sleepNSeconds(1);
            System.out.println("Playing " + (stopPlaying().getTime() - st) + " ms");
        }
    }
}
/*public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }
    }
}*/
