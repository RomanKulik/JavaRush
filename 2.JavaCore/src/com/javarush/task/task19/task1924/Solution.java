package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Замена чисел
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово]
от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map,
которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла,
но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок,
в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()))) {
            List<String> list = new ArrayList<>();
            while (fr.ready()) {
                String[] ss = fr.readLine().split(" ");
                StringBuilder sb = new StringBuilder();
                for (String s : ss) {
                    try {
                        if (map.containsKey(Integer.parseInt(s)))
                            sb.append(map.get(Integer.parseInt(s)) + " ");
                        else sb.append(s + " ");
                    } catch (NumberFormatException e) {
                        sb.append(s + " ");
                    }
                }
                System.out.println(sb);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void main(String[] args) {
    }
}*/
