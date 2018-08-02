package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> numbers = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            numbers.add(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        String fileName1 = args.length == 0 ? "d:/1.txt" : args[0];
        String fileName2 = args.length == 0 ? "d:/2.txt" : args[1];

        try (BufferedReader fr = new BufferedReader(new FileReader(fileName1));
             BufferedWriter fw = new BufferedWriter(new FileWriter(fileName2))) {
            while (fr.ready()) {
                String[] ss = fr.readLine().split(" ");
                for (String s : ss) {
                    if (s.matches(".*\\d+.*"))
                        fw.write(s + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
