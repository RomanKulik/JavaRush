package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть,
потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) {
        // D:\Lion\Lion.avi.part1
        TreeSet<String> files = new TreeSet<>();
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!"end".equals(fileName = reader.readLine()))
                files.add(fileName);
            compileFile(files);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void compileFile(TreeSet<String> files) throws IOException {
        int lastPointIndex = files.first().lastIndexOf('.');
        String newFileName = files.first().substring(0, lastPointIndex).trim();
        FileOutputStream out = new FileOutputStream(newFileName, true);
        for (String s : files)
            out.write(bytesFromFile(s));
        out.close();
    }

    private static byte[] bytesFromFile(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buff = new byte[in.available()];
        in.read(buff);
        in.close();
        return buff;
    }
}
