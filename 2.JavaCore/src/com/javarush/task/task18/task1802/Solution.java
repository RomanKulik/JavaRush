package com.javarush.task.task18.task1802;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Минимальный байт
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = null;
        InputStream in = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new FileInputStream(reader.readLine());
            System.out.println(minByte(in));
        }  finally {
           closeQuietly(reader);
           closeQuietly(in);
        }
    }

    private static int minByte(InputStream fis) throws IOException {
        ArrayList<Integer> arrInt = new ArrayList<>();

        while (fis.available() > 0) {
            arrInt.add(fis.read());
        }

        return Collections.min(arrInt);
    }

    public static void closeQuietly(Object input) {
        try {
            if (input != null) {
                if (input instanceof InputStream) {
                    ((InputStream) input).close();
                } else if (input instanceof Reader) {
                    ((Reader) input).close();
                }
            }
        } catch (IOException ioe) {
            // ignore
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
