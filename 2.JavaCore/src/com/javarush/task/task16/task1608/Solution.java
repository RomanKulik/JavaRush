package com.javarush.task.task16.task1608;

/* 
Продвижение на политических дебатах
Наш кандидат — Иванов!
И мы ему немного поможем, сделав так, чтобы он толкнул речь,
а затем снова речь, и ещё раз — речь на политических дебатах.
Подсобим ему немного, сделав так, чтобы он разговаривал до тех пор,
пока не завершится всё свободное время.
Нити нам в помощь!

Продвижение на политических дебатах
1. Разберись, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov,
чтобы Иванов разговаривал, пока не завершится всё свободное время.


Требования:
1. Вызови метод join у нужного объекта.
2. Метод toString класса политик Politician должен выводить
сколько речей сказал политик, например: "Иванов сказал речь 35 раз".
3. Программа должна создавать 3 объекта типа Politician.
4. Методы, которые отвечают за вывод в консоль, не изменять.
5. Вывод программы должен свидетельствовать о том,
что Иванов сказал больше всего речей на политических дебатах.
*/
public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;
    //private volatile static Integer countSounds;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        ivanov.join();
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");


        while (ivanov.getCountSpeeches() +
                petrov.getCountSpeeches() +
                sidorov.getCountSpeeches() < totalCountSpeeches) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
       //private volatile int countSounds;
      private volatile Integer countSounds;

        public Politician(String name) {
            super(name);
            countSounds = Integer.valueOf(0);
            start();
        }

        public void run() {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                /*  Иванов сказал речь 200 раз
                    Петров сказал речь 16 раз
                    Сидоров сказал речь 12 раз*/
               // countSounds++;

                /*  Иванов сказал речь 200 раз
                    Петров сказал речь 0 раз
                    Сидоров сказал речь 1 раз*/
               // volatileIncrement();

                /*  А вот такой результат будет,
                    если volatile вовсе убрать из переменной countSounds
                    Иванов сказал речь 200 раз
                    Петров сказал речь 56 раз
                    Сидоров сказал речь 200 раз*/

               /* //private volatile static Integer countSounds; - статическое поле класса Solution
               Без volatile - зависает
               Иванов сказал речь 67 раз
                 Петров сказал речь 67 раз
                 Сидоров сказал речь 67 раз*/
                synchronized (countSounds) {
                    int tmp = countSounds;
                    tmp++;
                    countSounds = Integer.valueOf(tmp);
                }
            }
        }

        private synchronized void volatileIncrement() {
            // https://habrahabr.ru/post/108016/
            int temp = 0;
            temp = countSounds;
            temp++;
            countSounds = temp;
        }

        public int getCountSpeeches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeeches());
        }
    }
}
/*public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000000;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");

        while (ivanov.getCountSpeeches() + petrov.getCountSpeeches() + sidorov.getCountSpeeches() < totalCountSpeeches) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int countSounds;

        public Politician(String name) {
            super(name);
            start();
        }

        public void run() {
            while (countSounds < totalCountSpeeches * soundsInOneSpeech) {
                countSounds++;
            }
        }

        public int getCountSpeeches() {
            return countSounds / soundsInOneSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getCountSpeeches());
        }
    }
}*/

