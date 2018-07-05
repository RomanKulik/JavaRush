package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
Подумайте, как связаны интерфейсы
Swimmable(способен плавать) и Walkable(способен ходить)
с классом OceanAnimal(животное океана).
Расставь правильно наследование интерфейсов и класса OceanAnimal.
И как могут быть связаны классы
Orca(Косатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal...

Исправление ошибок
1. Подумай, как связаны интерфейсы
Swimmable(способен плавать) и Walkable(способен ходить)
с классом OceanAnimal(животное океана).
2. Расставь правильно наследование интерфейсов и класса OceanAnimal.
3. Подумай, как могут быть связаны классы
Orca(Косатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal.
4. Расставь правильно наследование между классами
Orca, Whale, Otter и классом OceanAnimal.
5. Подумай, какой класс должен реализовать интерфейс
Walkable и добавить интерфейс этому классу.
6. Подумай, какое животное еще не умеет плавать и добавить ему интерфейс Swimable.


Требования:
1. Косатка(Orca) является животным океана(потомком OceanAnimal)
и умеет плавать(поддерживает интерфейс Swimmable).
2. Кит(Whale) является животным океана(потомком OceanAnimal)
и умеет плавать(поддерживает интерфейс Swimmable).
3. Выдра(Otter) умеет ходить(поддерживает интерфейс Walkable)
и плавать(поддерживает интерфейс Swimmable).
4. Выдра(Otter) НЕ является животным океана(потомком OceanAnimal).
5. Кит(Whale) и Косатка(Orca) НЕ умеют ходить(не поддерживают интерфейс Walkable).
*/
public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {

        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal implements Swimmable {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming() {

            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal {
        @Override
        public Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Whale extends OceanAnimal {
        @Override
        public Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Otter implements Swimmable, Walkable {

        @Override
        public void walk() {

        }

        @Override
        public void swim() {

        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.swimming();
        }

        private void swimming() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca {
    }

    static class Whale {

    }

    static class Otter {

    }
}*/
