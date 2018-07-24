package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader
c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world",
которые встречаются в файле.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
             FileReader fr = new FileReader(reader1.readLine())) {
            BufferedReader reader = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            while (reader.ready())
                sb.append(reader.readLine()).append(" ");

            System.out.println(Collections.
                    frequency(new ArrayList<>(
                            Arrays.asList(sb.toString().
                                    split("\\W"))), "world"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
