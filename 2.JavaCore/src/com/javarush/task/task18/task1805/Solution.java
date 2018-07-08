package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные
байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Byte> set = new TreeSet<>();
        try (InputStream is =
                     new FileInputStream(
                             new BufferedReader(
                                     new InputStreamReader(
                                             System.in)).readLine())){

            while (is.available() > 0)
                set.add((byte)is.read());

            set.forEach(o -> System.out.print(o + " "));
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
