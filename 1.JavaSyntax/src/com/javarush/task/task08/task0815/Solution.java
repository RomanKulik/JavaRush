package com.javarush.task.task08.task0815;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*

Перепись населения

Очень часто люди и прочие граждане Вселенной пытаются найти своих родственников.
Сделаем шаг к программе поиска людей.
В задачке нам нужно создать словарь (Map<String, String>)
занести в него десять записей по принципу «Фамилия» - «Имя»,
после чего проверить, сколько людей имеют совпадающие с заданным имя или фамилию.

Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу
«Фамилия» — «Имя».
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
5. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
6. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0, j = 0; i < 10; i++, j++) {
            if (j == 3) {
                j = 0;
            }
            map.put("LastName" + i, "FirstName" + j);
        }

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код

        return Collections.frequency(map.values(),name);
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
       /* int key = 0;
        for (String s:
                map.keySet()) {
            if (s.toLowerCase().equals(lastName.toLowerCase())) {
                key++;
            }
        }

        return key;*/

        return Collections.frequency(map.keySet(), lastName);
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println(map.toString());
        System.out.println(getCountTheSameLastName(map, "LastName1"));
        System.out.println(getCountTheSameFirstName(map, "FirstName1"));
    }
}

/*public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}*/
