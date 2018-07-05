package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
На самом деле то, что мы сейчас с вами делаем, —
это самая настоящая затравка для создания компьютерных игр, а точнее,
их персонажей, которые бегают, плавают, летают…
Так что смелее вперед, создаем интерфейсы движения и добавляем их в классы Тигра, Собаки, Кота и Утки.

Лазать, летать и бегать
1. Внутри класса Solution создай интерфейс public interface Fly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface Climb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface Run(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).


Требования:
1. Класс Solution должен содержать интерфейс Fly с методом void fly().
2. Класс Solution должен содержать интерфейс Climb с методом void climb().
3. Класс Solution должен содержать интерфейс Run с методом void run().
4. Объект класса Cat должен уметь бегать(поддерживать интерфейс Run)
и лазить по деревьям(поддерживать интерфейс Climb).
5. Объект класса Dog должен уметь бегать(поддерживать интерфейс Run).
6. Класс Tiger должен быть котом.
7. Объект класса Duck должен уметь бегать(поддерживать интерфейс Run) и летать(поддерживать интерфейс Fly).
*/
public class Solution {

    public class Cat implements Run, Climb {
        @Override
        public void climb() {

        }

        @Override
        public void run() {

        }
    }

    public class Dog implements Run {
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Fly, Run {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }

    public interface Fly {
        void fly();
    }
    public interface Climb {
        void climb();
    }
    public interface Run {
        void run();
    }
}
/*public class Solution {

    public class Cat {
    }

    public class Dog {
    }

    public class Tiger extends Cat {
    }

    public class Duck {
    }
}*/
