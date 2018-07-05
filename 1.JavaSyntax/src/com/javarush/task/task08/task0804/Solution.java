package com.javarush.task.task08.task0804;

import java.util.HashMap;
import java.util.Map;

/* 

Вывести на экран список ключей

Явки, пароли, ключи!
Пойманному секретному агенту придется всё это выложить, как на духу…
Хотя нет, ключей и паролей будет достаточно. У него извлекли маленькую программу, 
в которой была коллекция HashMap с десятью строками. 
Ваша задача — вывести на экран список ключей, печатая каждый элемент с новой строки.
Вывести на экран список ключей
Есть коллекция HashMap<String, String>, туда занесли 10 различных строк.
Вывести на экран список ключей, каждый элемент с новой строки.


Требования:
1. Программа должна создавать переменную коллекции
HashMap с типом элементов String, String.
Переменная должна быть сразу проинициализирована.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 различных строк, согласно условию.
4. Метод printKeys() должен выводить на экран список ключей коллекции,
каждый элемент с новой строки.
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

        printKeys(map);
    }

    public static void printKeys(Map<String, String> map) {
        //напишите тут ваш код
        /*for (HashMap.Entry<String, String> pair:
             map.entrySet()) {
            System.out.println((pair.getKey()));
        }*/

       // map.forEach((K, V) -> System.out.println(K + " "));


    }
}

/*
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

        printKeys(map);
    }

    public static void printKeys(Map<String, String> map) {
        //напишите тут ваш код
    }
}
*/
