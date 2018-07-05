package com.javarush.task.task12.task1225;

/* 
В террианский зоопарк прибыла группа туристов с планеты Талли.
Оказалось, что в заведении все таблички с названиями были украдены роботами,
нужжающимися в металле для лечения. Простим роботов, но напишем метод, который определяет,
какой объект в него передали (кот, лев, тигр, бык, корова или просто животное).

Посетители
Напиши метод, который определяет, какой объект передали в него.
Программа должна выводить на экран одну из надписей:
«Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».

Замечание:
постарайся определять тип животного как можно более точно.


Требования:
1. Класс Solution должен содержать классы Cat, Tiger, Lion, Bull, Cow, Animal.
2. Класс Solution должен содержать метод String getObjectType(Object o).
3. Метод getObjectType() должен возвращать строку «Кот» если передан объект типа Cat.
4. Метод getObjectType() должен возвращать строку «Тигр» если передан объект типа Tiger.
5. Метод getObjectType() должен возвращать строку «Лев» если передан объект типа Lion.
6. Метод getObjectType() должен возвращать строку «Бык» если передан объект типа Bull.
7. Метод getObjectType() должен возвращать строку «Животное» если передан объект типа Animal.
8. Программа должна выводить на экран результат метода getObjectType().
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        if (o instanceof Cat) {
            if (o.getClass().getSimpleName().equals("Cat")) return "Кот";
            else if (o.getClass().getSimpleName().equals("Tiger")) return "Тигр";
            else return "Лев";
        } else if (o.getClass().getSimpleName().equals("Cow")) return "Корова";
        else if (o.getClass().getSimpleName().equals("Bull")) return "Бык";
        /*else if (o.getClass().getSimpleName().equals("Animal"))*/
        return "Животное";
    }



    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Cat extends Animal {  //<--Классы наследуются!!
    }

    public static class Animal {
    }
}
/*public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код

        return "Животное";
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}*/
