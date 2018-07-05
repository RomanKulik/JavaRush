package com.javarush.task.task16.task1617;

import java.util.concurrent.TimeoutException;

/*
Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так,
чтобы каждую секунду через пробел выдавался отсчет
начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более,
прерви ее методом interrupt и внутри нити выведи в консоль слово [Пр

Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более,
прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].

Пример для countSeconds=4 :
"4 3 2 1 Прервано!"

4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 :
"3 2 1 Марш!"

PS: метод sleep выбрасывает InterruptedException.


Требования:
1. Метод run класса RacingClock должен содержать цикл.
2. Объект класса RacingClock должен каждую секунду
уменьшать значение переменной countSeconds на единицу.
3. Метод main должен вызывать Thread.sleep(3500).
4. Метод main должен вызывать метод interrupt у объекта clock.
5. Если countSeconds равно 3, то программа должна вывести "3 2 1 Марш!".
6. Если countSeconds равно 4, то программа должна вывести "4 3 2 1 Прервано!".
*/
public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        clock.run();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (countSeconds > 0) {
                    System.out.print(countSeconds-- + " ");
                    Thread.sleep(1000);
                }
                System.out.print("Марш!");
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
                return;
            }
        }
        /*public void run() {
            //add your code here - добавь код тут
            int myCount = countSeconds;
            try {
                while (myCount > 0) {
                    System.out.print(myCount-- + " ");
                    Thread.sleep(1000);
                }
                if (countSeconds > 3) {
                    this.interrupt();
                    Thread.sleep(1);
                }
                System.out.print("Марш!");
            } catch (InterruptedException e) {
                System.out.print("Прервано!");
                return;
            }
        }*/
    }
}
/*public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
        }
    }
}*/
