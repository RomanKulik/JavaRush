package com.javarush.task.task08.task0805;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*

На экране — значения!

Секретный агент попал в засаду. Чтобы информация, которой он обладает, не пропала,
он должен запустить одно приложение на своем лептопе. В этом приложении он нашёл коллекцию HashMap,
в ней — 10 строк. Помогите секретному агенту вывести значения коллекции на экран,
печатая каждый элемент с новой строки.

На экране — значения!
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк.
Вывести на экран список значений, каждый элемент с новой строки.


Требования:
1. Программа должна создавать переменную коллекции HashMap с типом элементов String, String.
Переменная должна быть сразу проинициализирована.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 различных строк, согласно условию.
4. Метод printValues() должен выводить на экран список значений коллекции, каждый элемент с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map) {
        //напишите тут ваш код
        /*Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }*/

        //map.forEach((k, v) -> System.out.println(k + "\n" + v));

        for (Map.Entry<String, String> pair :
                map.entrySet()) {
           // System.out.println(pair.getKey());
            System.out.println(pair.getValue());
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map) {
        //напишите тут ваш код

    }
}*/
