package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.*;

/*

Номер месяца

Временные промежутки «год» и «месяц», принятые на Терре,
используются и на других планетах и объектах Федерации,
в том числе — на корабле JRush.
Однако зачастую стажёры экипажа внеземного происхождения путаются,
когда речь заходит о земных месяцах. Поможем им: напишем программу с коллекциями,
которая по имени месяца выведет его номер на экран.

Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде:
«May is 5 month».
Используйте коллекции.

Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна использовать коллекции.
5. Программа должна считывать с клавиатуры имя месяца и
выводить его номер на экран по заданному шаблону.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String month = reader.readLine().toLowerCase().trim();
        String res = (month.substring(0, 1).toUpperCase() + month.substring(1));
        //System.out.println(res);

        Map<String, Integer> map = new HashMap<>();
        /*map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("July", 7);
        map.put("August", 8);
        map.put("September", 9);
        map.put("October", 10);
        map.put("November", 11);
        map.put("December", 12);*/
       //System.out.println(res + " is " + map.get(res) + " month");

        for (int i = 1; i < 13; i++) {
            map.put(Month.of(i).toString(), i);
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println(res + " is " + map.get(res.toUpperCase()) + " month");
    }
}

/*public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
    }
}*/
