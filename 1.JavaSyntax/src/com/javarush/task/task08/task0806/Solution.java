package com.javarush.task.task08.task0806;

import java.util.*;

/*

Коллекция HashMap из Object

Работа с коллекциями требует сноровки и профессионализма.
Вот почему совсем зелёных новичков к ним не подпускают и на пушечный выстрел.
Но на восьмом уровне пора начинать разбираться с ними.
Допустим, у нас есть коллекция HashMap<String, Object>,
и туда занесли 10 различных пар объектов.
Ваша задача — вывести содержимое коллекции на экран.

Коллекция HashMap из Object
Есть коллекция HashMap<String, Object>, туда занесли 10 различных пар объектов.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.

Пример вывода (тут показана только одна строка):
Sim - 5


Требования:
1. Программа должна создавать переменную коллекции HashMap с типом элементов String, Object.
Переменная должна быть сразу проинициализирована.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 различных объектов, согласно условию.
4. Программа должна выводить на экран список значений коллекции, каждый элемент с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        //напишите тут ваш код
        //map.forEach((k, v) -> System.out.println(String.format("%s - %s", k, v )));

        for (HashMap.Entry<String, Object> pair : map.entrySet()) {
            //System.out.println(pair.getKey() + " - " + pair.getValue());

            //System.out.println(key + " - " + map.get(key));
           // System.out.println(pair.getKey() + " - " + map.get(pair.getKey()));
        }
        /*List list = new ArrayList(map.entrySet());
        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());

        }*/

        System.out.println(map.toString());
    }
}
