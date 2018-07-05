package com.javarush.task.task15.task1509;

/* 
Мужчина или женщина?
Что-то в этой программе не так...
Имена мужчин она вроде как печатает, а вот женские — нет.
Долой дискриминацию: измените метод printName так,
чтобы он выполнялся и для man, и для woman.
Реализация метода должна быть одна.

Мужчина или женщина?
1. Изменить метод printName так, чтобы он выполнялся для man и woman.
2. Реализация метода printName должна быть одна.


Требования:
1. В классе Solution должен быть реализован только один метод printName.
2. Метод printName должен принимать один параметр типа Human.
3. Класс Man должен быть потомком класса Human.
4. Класс Woman должен быть потомком класса Human.
*/
public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Human human) {

    }

    public static class Human {

    }

    public static class Man extends Human {

    }

    public static class Woman extends Human {

    }
}
/*public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        printName(man);
        printName(woman);
    }

    public static void printName(Man man) {

    }

    public static class Human {

    }

    public static class Man {

    }

    public static class Woman {

    }
}*/
