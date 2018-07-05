package com.javarush.task.task08.task0802;

/*

HashMap из 10 пар

В лекциях наставники рассказывали, что Map – это набор пар «ключ»-«значение»,
где ключ — уникальное название, по которому к нему можно было обращаться.
Начинаем работать с коллекцией HashMap. Создадим одну такую коллекцию,
и расскажем людям о типах растений. Например, значение — ягода, ключ — арбуз.

HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз — ягода,
банан — трава,
вишня — ягода,
груша — фрукт,
дыня — овощ,
ежевика — куст,
жень-шень — корень,
земляника — ягода,
ирис — цветок,
картофель — клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.

Пример вывода (тут показана только одна строка):
картофель - клубень


Требования:
1. Объяви переменную коллекции HashMap с типом элементов String, String и сразу проинициализируй ee.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 пар строк, согласно условию.
4. Программа должна выводить содержимое коллекции на экран, каждую пару через дефис и с новой строки.
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> entry = new HashMap<String, String>();
        entry.put("арбуз", "ягода");
        entry.put("банан", "трава");
        entry.put("вишня", "ягода");
        entry.put("груша", "фрукт");
        entry.put("дыня", "овощ");
        entry.put("ежевика", "куст");
        entry.put("жень-шень", "корень");
        entry.put("земляника", "ягода");
        entry.put("ирис", "цветок");
        entry.put("картофель", "клубень");

        entry.forEach((k, v) -> System.out.println(k + " - " + v));

        for (HashMap.Entry<String, String> pair : entry.entrySet()) {
            String key = pair.getKey();
            String value =  pair.getValue();
            System.out.println( key + " - " + value);
        }

        Iterator<Map.Entry<String, String>> iterator = entry.entrySet().iterator();

       while (iterator.hasNext()) {
           HashMap.Entry<String, String> entry1 = iterator.next();
           String key = entry1.getKey();
           String value = entry1.getValue();

           System.out.println(key + " - " + value);
       }
    }
}
