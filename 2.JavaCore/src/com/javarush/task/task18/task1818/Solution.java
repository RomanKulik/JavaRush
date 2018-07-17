package com.javarush.task.task18.task1818;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Два в одном
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла,
а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл
(в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             OutputStream f1 = new FileOutputStream(reader.readLine(), true);
             InputStream f2 = new FileInputStream(reader.readLine());
             InputStream f3 = new FileInputStream(reader.readLine());) {
            copy(f2, f1);
            copy(f3, f1);
        } catch (IOException e) {
        }
    }

    private static void copy(InputStream source, OutputStream target) throws IOException {
        byte[] buff = new byte[8 * 1024];
        int count;
        while ((count = source.read(buff)) != -1){
            target.write(buff, 0, count);
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }
}*/