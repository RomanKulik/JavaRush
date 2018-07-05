package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
Пришло новое задание от капитана Боброва: считать с консоли имя файла.
Затем вывести в консоль (на экран) содержимое этого файла.
В конце не забудьте освободить ресурсы, закрыть поток чтения с файла и поток ввода с клавиатуры.

Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0) {
            char ch = (char) fileInputStream.read();
            System.out.print(ch);
        }
        fileInputStream.close();
        reader.close();
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}*/
