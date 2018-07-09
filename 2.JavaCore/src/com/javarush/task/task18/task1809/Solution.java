package com.javarush.task.task18.task1809;

/* 
Реверс файла
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(System.in));
             InputStream in = new FileInputStream(reader.readLine());
             OutputStream out = new FileOutputStream(reader.readLine())) {
            byte[] buff = new byte[in.available()];
           /* byte[] buff = Files.readAllBytes(
                    new File(reader.readLine()).toPath());*/
            in.read(buff);
            for (int i = buff.length - 1; i >= 0; i--)
                out.write(buff[i]);
        } catch (IOException ignore) {
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {

    }
}*/
