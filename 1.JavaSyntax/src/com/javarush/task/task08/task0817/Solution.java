package com.javarush.task.task08.task0817;

import java.util.*;

/*

Нам повторы не нужны

Сложно представить себе ситуацию, в которой может понадобиться програма,
которую мы предлагаем вам написать.
Впрочем, маленькая модификация, и она обретает практический смысл.
Также её можно представить частью чего-то большего (поиска?).
Давайте создим словарь, занесём в него записи по принципу «фамилия» - «имя» и
удалим людей с одинаковыми именами.

Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу
«фамилия» — «имя».
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap
с типом элементов String, String состоящих из 10 записей.
5. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей,
имеющие одинаковые имена.
6. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0, j = 1; i < 10; i++, j++) {
            if (j == 8) {
                j = 0;
            }
            map.put("firstName" + i, "name" + j);
        }

       /* map.put("firstName100", "nameN");
        map.put("firstName101", "nameM");*/


        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> tmp = new HashMap<>(map);

        for(Map.Entry<String, String> pair : tmp.entrySet()) {
            if (Collections.frequency(map.values(), pair.getValue()) != 1) {
                removeItemFromMapByValue(map, pair.getValue());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }
}
