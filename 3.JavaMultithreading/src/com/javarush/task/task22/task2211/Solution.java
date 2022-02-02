package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
Смена кодировки from file(Windows-1251) to file(UTF-8)
В метод main первым параметром приходит имя файла,
тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла,
в который необходимо записать содержимое первого файла в кодировке UTF-8.


Requirements:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать
содержимому первого файла за исключением кодировки(UTF-8).
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(
                             new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter bw =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


/*
package com.javarush.task.task22.task2211;

import java.io.IOException;

/*
Смена кодировки
Смена кодировки
В метод main первым параметром приходит имя файла,
тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла,
в который необходимо записать содержимое первого файла в кодировке UTF-8.


Requirements:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать
содержимому первого файла за исключением кодировки(UTF-8).


public class Solution {
    public static void main(String[] args) throws IOException {
    }
}

 */