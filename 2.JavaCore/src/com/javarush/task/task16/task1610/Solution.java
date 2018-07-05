package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
Сначала кошка рожает котят.
Потом все котята вылазят из корзинки в произвольном порядке.
В конце кошка собирает их назад в корзинку.
Все события для одной кошки могут быть перемешаны с событиями для другой кошки.
А теперь реализуйте это с помощью join().

Расставь вызовы методов join()
1. Разберись, что делает программа.
2. Расставь вызовы методов join() так, чтобы для каждой кошки выполнялось следующее:
2.1. Сначала кошка рожает котят.
2.2. Потом все котята вылазят из корзинки в произвольном порядке.
2.3. В конце кошка собирает их назад в корзинку.
2.4. Все события для одной кошки могут быть перемешаны с событиями для другой кошки.
2.5. Добавить сон котят (200 мс) в investigateWorld.


Требования:
1. У каждого котенка (объекта типа Kitten) должен быть вызван метод join.
2. Метод investigateWorld должен обеспечивать сон котенка на 200 мс.
Используй метод Thread.sleep(200).
3. Программа должна создавать две кошки и четыре котенка.
4. Методы, которые отвечают за вывод в консоль, не изменять.
5. Вывод программы должен отображать выполнение требований условия.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
        //cat2.setPriority(10);
    }

    private static void investigateWorld() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }

    public static class Cat /*extends Thread*/ implements Runnable {
        protected Kitten kitten1;
        protected Kitten kitten2;
        private String name;

        public String getName() {
            return name;
        }

        public Cat(String name) {
            //super(name);
            this.name = name;
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
//            start();
            run();
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKitten();
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKitten() throws InterruptedException {
            kitten1.start();
            kitten1.join();
            kitten2.start();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
