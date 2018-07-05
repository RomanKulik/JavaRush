package com.javarush.task.task12.task1204;

/* 
Что общего у птицы и лампы?
То, что и птицы, и лампы могут быть объектами своих классов.
А объекты можно передавать в методы в качестве переменных.
В этой задаче пишем метод, который определяет, объект какого класса ему передали,
и выводит на экран одну из надписей:
Кошка, Собака, Птица, Лампа.

То ли птица, то ли лампа
Написать метод, который определяет, объект какого класса ему передали,
и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Cat менять нельзя.
3. Класс Dog менять нельзя.
4. Класс Bird менять нельзя.
5. Класс Lamp менять нельзя.
6. Метод printObjectType() должен выводить на экран одну из надписей, в зависимости от переданного объекта.
Например "Лампа" для объектов типа Solution.Lamp.
*/
public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        //System.out.println(o.getClass().getSimpleName());
        if (o instanceof Cat) {
            System.out.println("Кошка");
        } else if (o instanceof Bird) {
            System.out.println("Птица");
        } else if (o instanceof Lamp) {
            System.out.println("Лампа");
        } else if (o instanceof Dog) {
            System.out.println("Собака");
        } else {
            System.out.println("There is no such class there");
        }
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
/*public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}*/
