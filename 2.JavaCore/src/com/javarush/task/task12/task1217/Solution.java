package com.javarush.task.task12.task1217;

/* 
Здорово быть Суперменом!
Он летает стремительно, как молния, бегает быстрее ветра, плывет, как Плотва.
Или, постойте, Супермен вообще плавать умеет? Впрочем, неважно.
Напишите заготовку для супергероя, который будет летать, плавать и бежать.
Делать это нужно с помощью реализации интерфейсов Fly, Run, Swim.

Лететь, бежать и плыть
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.


Требования:
1. Класс Solution должен содержать интерфейс Fly.
2. Класс Solution должен содержать интерфейс Run.
3. Класс Solution должен содержать интерфейс Swim.
4. Интерфейс Fly должен содержать один метод.
5. Интерфейс Run должен содержать один метод.
6. Интерфейс Swim должен содержать один метод.
*/
public class Solution {
    public static void main(String[] args) {

    }

    //add interfaces here - добавь интерфейсы тут
    public interface Fly {
        void fly();
    }

    public interface Run {
        void run();
    }

    public interface Swim {
        void swim();
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //add interfaces here - добавь интерфейсы тут
}*/
