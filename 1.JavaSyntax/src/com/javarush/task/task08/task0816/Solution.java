package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 

Добрая Зинаида и летние каникулы

Зинаида Васильевна — классный руководитель 7-Б класса какой-то там террианской школы,
подробности не важны.
А важно то, что она дарит подарки ученикам в дни рождения.
Везет не всем: летние именинники — в пролёте по причине каникул.
Пишем программу для Зинаиды: создаем словарь с фамилиями и датами рождения,
удаляем из него людей, родившихся летом.

Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу:
«фамилия» — «дата рождения».
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов
String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Bush", new Date("MAY 4 1985"));
        map.put("Ivanov", new Date("JULY 25 1978"));
        map.put("Oland", new Date("NOVEMBER 12 1991"));
        map.put("Ford", new Date("MARCH 21 2003"));
        map.put("Washington", new Date("FEBRUARY 8 1982"));
        map.put("Jeferson", new Date("SEPTEMBER 17 1999"));
        map.put("Mugabe", new Date("APRIL 4 1982"));
        map.put("Adenauer", new Date("DECEMBER 29 2007"));
        map.put("Bismark", new Date("JUNE 3 1975"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        java.util.Iterator<HashMap.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry<String, Date> pair = it.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8 )
                it.remove();
        }
        /*Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int n = iterator.next().getValue().getMonth();

            if (n > 4 && n < 8 ) {
                System.out.println(n);
                iterator.remove();
            }
        }*/

        //напишите тут ваш код
       /* Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
        Map.Entry<String, Date> pair = iter.next();
        int month = pair.getValue().getMonth();
        if ( (month>=5) && (month <=7) ) {
            System.out.println(month);
            iter.remove(); }
        }*/
    }

    public static void main(String[] args) {
      /*  HashMap<String, Date> map = createMap();
        System.out.println(map.toString());

        removeAllSummerPeople(map);

        map.forEach((s, date) -> System.out.println(s + ": " + date));*/



    }
}

/*public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}*/
