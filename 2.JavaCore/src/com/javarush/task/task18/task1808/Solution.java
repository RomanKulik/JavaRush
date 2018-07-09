package com.javarush.task.task18.task1808;

/* 
Разделение файла
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             InputStream in = new FileInputStream(reader.readLine());
             OutputStream out1 = new FileOutputStream(reader.readLine());
             OutputStream out2 = new FileOutputStream(reader.readLine())) {

            byte[] buff = new byte[in.available()];
            in.read(buff);
            int size = buff.length % 2 == 0 ? buff.length / 2 : buff.length / 2 + 1;
            out1.write(buff, 0, size);
            out2.write(buff, size, buff.length % 2 == 0 ? size : size - 1);
        } catch (IOException ignore) {
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {

    }
}*/
