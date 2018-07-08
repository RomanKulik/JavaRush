package com.javarush.task.task18.task1803;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.io.*;
import java.util.*;

/* 
Самые частые байты
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла
с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            printRes(freq(fis));
        } /*catch (IOException ignore) {
        }*/
    }

    private static Map<Integer, Integer> freq(FileInputStream fis) throws IOException {
        List<Integer> bytes = new ArrayList();
        while (fis.available() > 0)
            bytes.add(fis.read());
        Collections.sort(bytes);
       // System.out.println("bytes:\n" + Arrays.asList(bytes));

        Map<Integer, Integer> map = new HashMap<>(); // for fastest search by key
        // посчитать сколько раз key встречается
        for (Integer i :
                bytes) {
            if (map.containsKey(i)) {
                Integer val = map.get(i);
                map.put(i, ++val);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    private static void printRes(Map<Integer, Integer> map) {
        // найти max в value
        int maxValue = Collections.max(map.values());
        // вывести все ключи через пробел с maxValue
        for (Map.Entry<Integer, Integer> pair:
             map.entrySet()) {
            if (pair.getValue() == maxValue)
                System.out.print(pair.getKey() + " ");
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
