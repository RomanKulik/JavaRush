package com.javarush.task.task12.task1218;

/* 
Кто-то добрый и заботливый уже написал для вас чудесные интерфейсы «летать»,
«передвигаться» и «потреблять пищу».
Добавьте их классам собаки, утки, автомобиля и самолёта.
Руководствуясь фантазией и здравым смыслом.
Иногда последний программисту пригождается.

Есть, летать и двигаться
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).


Требования:
1. Класс Solution должен содержать интерфейс Fly с одним методом fly().
2. Класс Solution должен содержать интерфейс Move с одним методом move().
3. Класс Solution должен содержать интерфейс Eat с одним методом eat().
4. Собака должна уметь передвигаться и есть.
5. Автомобиль должен уметь передвигаться.
6. Самолет должен уметь передвигаться и летать.
7. Утка должна уметь передвигаться, летать и есть.
*/
public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Move {
        public void move();
    }

    public interface Eat {
        public void eat();
    }

    public class Dog implements Move, Eat {
        @Override
        public void move(){}

        @Override
        public void eat() {}
    }

    public class Duck implements Move, Eat, Fly {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    public class Car implements Move {
        @Override
        public void move() {

        }
    }

    public class Airplane implements Move, Fly {
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Move {
        public void move();
    }

    public interface Eat {
        public void eat();
    }

    public class Dog {
    }

    public class Duck {
    }

    public class Car {
    }

    public class Airplane {
    }
}*/
