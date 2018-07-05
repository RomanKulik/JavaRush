package com.javarush.task.task12.task1205;

/* 
Жизненно важно уметь определять, к какому относится животное, считает разводчик кошек Павловна.
Давайте поможем Павловне и напишем метод, который определяет, объект какого класса ему передали,
и возвращает результат:
«Корова», «Кит», «Собака», «Неизвестное животное».

Определимся с животным
Написать метод, который определяет, объект какого класса ему передали,
и возвращает результат – одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное».


Требования:
1. Программа должна выводить текст на экран.
2. Класс Cow менять нельзя.
3. Класс Dog менять нельзя.
4. Класс Whale менять нельзя.
5. Класс Pig менять нельзя.
6. Метод getObjectType() должен возвращать одно значение из:
«Корова», «Кит», «Собака», «Неизвестное животное» в зависимости от переданного объекта.
Например "Корова" для объектов типа Solution.Cow.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        switch (o.getClass().getSimpleName()) {
            case "Cow":
                return "Корова";
            case "Dog":
                return "Собака";
            case "Whale":
                return "Кит";
            case "Pig":
                return "Неизвестное животное";
            default:
                return "Неизвестное животное";
        }

    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
/*public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение

        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}*/
