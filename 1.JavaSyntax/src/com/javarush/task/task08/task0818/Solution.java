package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 

Только для богачей

Наш заказчик — казино «Риге-Тау» с планеты Диблублублу.
Крайне заносчивые ребята, но платят хорошо.
Они заказали нам сделать программу автоматической рассылки писем потенциальным клиентам.
Не пугайтесь, джуниору (вам) поручена простая задача:
создать словарь типа «фамилия»-«зарплата» и удалить из него тех,
у кого зарплата ниже 500 кредитов.

Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
5. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.

*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0, j = 495; i < 10; i++, j++) {
            map.put("name" + i, j);
        }

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        Iterator<Integer> iter = map.values().iterator();

        while (iterator.hasNext()) {
            int sal = iterator.next().getValue();

            if (sal < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        //removeItemFromMap(createMap());
    }
}