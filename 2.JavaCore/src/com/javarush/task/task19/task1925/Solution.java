package com.javarush.task.task19.task1925;

/* 
Длинные слова
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName0 = args.length > 0 ? args[0] : "d:/0.txt";
        String fileName1 = args.length > 0 ? args[1] : "d:/1.txt";

        try (BufferedReader fr = new BufferedReader(new FileReader(fileName0));
             BufferedWriter fw = new BufferedWriter(new FileWriter(fileName1))) {
            StringBuilder sb = new StringBuilder();
            while (fr.ready()) {
                String[] ss = fr.readLine().split(" ");
                for (String s : ss)
                    if (s.length() > 6)
                        sb.append(s + ",");
            }
            fw.write(sb.delete(sb.length() - 1, sb.length()).toString());
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
