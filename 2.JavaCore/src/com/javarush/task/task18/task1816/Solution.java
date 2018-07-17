package com.javarush.task.task18.task1816;

/* 
Английские буквы
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        //if (args.length > 0)
            fileName = args[0];
        //fileName = "d:/0.txt";
        FileInputStream fin = new FileInputStream(fileName);
        int end, count = 0;
        byte A = (byte)'A';
        byte Z = (byte)'Z';
        byte a = (byte)'a';
        byte z = (byte)'z';

        while ((end = fin.read()) != -1){
            if (end >= A && end <= Z ||
                    end >= a && end <= z){
                count++;
            }
        }
        System.out.println(count);
        fin.close();
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
