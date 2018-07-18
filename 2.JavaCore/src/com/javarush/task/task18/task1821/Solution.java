package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String fileName;
        if (args.length == 0)
            fileName = "d:/englishText.txt";
        else
            fileName = args[0];

        try (FileInputStream in = new FileInputStream(fileName)) {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);

            printMap(getSortedMap(bytes));

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void printMap(Map<Byte,Integer> map) {
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            char ch = (char) (entry.getKey() & 0xFF);
            System.out.println(ch + " " + entry.getValue());
        }
    }

    private static Map<Byte,Integer> getSortedMap(byte[] bytes){
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            list.add(bytes[i]);
        }

        Map<Byte, Integer> map = new TreeMap<>();
        for (Byte key : list) {
            int value = Collections.frequency(list, key);
            map.put(key, value);
        }

       // System.out.println(map.toString());
        return map;
    }
}

/*public class Solution {
    public static void main(String[] args) {

    }
}*/
