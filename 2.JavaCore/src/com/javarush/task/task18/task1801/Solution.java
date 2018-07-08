package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.*;

/* 
Максимальный байт
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream in = new FileInputStream(fileName);
        System.out.println(maxByte(in));

    }

    static Integer maxByte(FileInputStream in) throws IOException {
       Set<Integer> byteSet = new TreeSet<>();
       while (in.available() > 0) {
           byteSet.add(in.read());
       }
       in.close();
       return Collections.max(byteSet);
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
