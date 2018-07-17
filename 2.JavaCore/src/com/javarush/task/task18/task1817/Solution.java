package com.javarush.task.task18.task1817;

/* 
Пробелы
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов.
Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            fileName = "d:/0.txt";
        }
        FileInputStream fin = new FileInputStream(fileName);

        byte space = (byte)' ';
        int end, spaceCount = 0, charCount = 0;

        while ((end = fin.read()) != -1){
            if (end == space)
                spaceCount++;
            charCount++;
        }
        double result = (double) spaceCount/charCount*100;
        System.out.printf("%.2f", result);
        fin.close();
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/