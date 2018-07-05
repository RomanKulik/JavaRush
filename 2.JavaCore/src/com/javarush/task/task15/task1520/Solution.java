package com.javarush.task.task15.task1520;

/* 
Тренировка мозга
Найдите логическую ошибку:
утка (Duck) должна корректно реализовывать интерфейс Movable.
Исправьте ошибку так, чтобы получить правильный результат.

Тренировка мозга
Найти логическую ошибку:
утка(Duck) должна корректно реализовывать интерфейс Movable.
Исправьте ошибку.

Результат вывода в консоль должен быть:
flying
moving

Требования:
1. Результат вывода на экран должен соответствовать условию.
2. В классе Duck должен быть реализован метод doAnotherAction.
3. Метод doAnotherAction() в классе Duck должен выводить на экран строку "moving".
4. Метод move в классе Util должен вызывать метод doAnotherAction
у переданного ему объекта.
5. Класс Duck должен реализовывать интерфейс Movable.
6. Класс Duck должен реализовывать интерфейс Flyable.
*/
public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }

        @Override
        public void doAnotherAction() {
            System.out.println("moving");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
            animal.doAnotherAction();
        }
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAnotherAction();
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
            animal.doAction();
        }
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAnotherAction();
    }
}*/
