package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.*;

/* 
Самые редкие байты
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла
с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (InputStream is =
                     new FileInputStream(
                             new BufferedReader(
                                     new InputStreamReader(System.in)).readLine())) {
            printMap(freq(is));
        }
    }

    private static Map<Byte, Integer> freq(InputStream is) throws IOException {
        List<Byte> bytes = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();

        while (is.available() > 0)
            bytes.add((byte) (is.read()));

        int freq;
        for (byte b : bytes) {
            freq = Collections.frequency(bytes, b);
            map.put(b, freq);
        }

        return map;
    }

    private static void printMap(Map<Byte, Integer> map) {
        int min = Collections.min(map.values());

        for (Map.Entry<Byte, Integer> pair :
                map.entrySet()) {
            if (pair.getValue() == min)
                System.out.print(pair.getKey() + " ");
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
