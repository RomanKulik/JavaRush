package com.javarush.task.task18.task1810;

/* 
DownloadException
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = null;
        try {
            while (true) {
                in = new FileInputStream(reader.readLine());
                System.out.println(in.available());
                if (in.available() < 1000) {
                    System.out.println(in.available());
                    throw new DownloadException();
                }
            }
        } catch (IOException ignore) {
        } finally {
            try {
                reader.close();
            } catch (IOException ignore) {
            }

            try {
                in.close();
            } catch (IOException ignore) {
            }
        }
    }


    public static class DownloadException extends Exception {

    }
}

/*public class Solution {
    public static void main(String[] args) throws DownloadException {

    }

    public static class DownloadException extends Exception {

    }
}*/
