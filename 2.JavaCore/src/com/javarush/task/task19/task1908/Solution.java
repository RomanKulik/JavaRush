package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader breader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bwriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            StringBuilder sb = new StringBuilder();
            while (breader.ready()) sb.append(breader.readLine()).append(" ");
            bwriter.write(sb.toString().
                    replaceAll("[a-zA-Zа-яА-Я0-9][a-zA-Zа-яА-Я][a-zA-Zа-яА-Я0-9]*", " ").
                    replaceAll("\\s+", " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
