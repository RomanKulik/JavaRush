package com.javarush.task.task11.task1109;

/* 
Кошки и собаки — не лучшие друзья, но друг без друга им бывает скучно.
Давайте не будем мешать их буйному взаимодействию друг с другом,
оставим публичными соответствующие методы классов Cat и Dog.
Все остальные методы, а также внутренние переменные — скроем от глаз и шаловливых ручек.

Как кошка с собакой
Скрыть все внутренние переменные класса Cat и Dog.
Также скрыть все методы, кроме тех, с помощью которых эти классы взаимодействуют друг с другом.


Требования:
1. Переменные класса Cat должны быть скрыты.
2. Переменные класса Dog должны быть скрыты.
3. Геттер getName класса Cat должен быть приватным.
4. Геттер getSpeed класса Cat должен быть приватным.
5. Метод isDogNear класса Cat должен быть публичным.
6. Геттер getName класса Dog должен быть приватным.
7. Геттер getSpeed класса Dog должен быть приватным.
8. Метод isCatNear класса Dog должен быть публичным.
*/
public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska", 5);
        Dog dog = new Dog("Sharik", 4);

        cat.isDogNear(dog);
        dog.isCatNear(cat);
    }

    public static class Cat {
        private String name;
        private int speed;

        public Cat(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        private String getName() {
            return name;
        }

        private int getSpeed() {
            return speed;
        }

        public boolean isDogNear(Dog dog) {
            return this.speed > dog.getSpeed();
        }
    }

    public static class Dog {
        private String name;
        private int speed;

        public Dog(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        private String getName() {
            return name;
        }

        private int getSpeed() {
            return speed;
        }

        public boolean isCatNear(Cat cat) {
            return this.speed > cat.getSpeed();
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat("Vaska", 5);
        Dog dog = new Dog("Sharik", 4);

        cat.isDogNear(dog);
        dog.isCatNear(cat);
    }

    public static class Cat {
        public String name;
        public int speed;

        public Cat(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean isDogNear(Dog dog) {
            return this.speed > dog.getSpeed();
        }
    }

    public static class Dog {
        public String name;
        public int speed;

        public Dog(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean isCatNear(Cat cat) {
            return this.speed > cat.getSpeed();
        }
    }
}*/



