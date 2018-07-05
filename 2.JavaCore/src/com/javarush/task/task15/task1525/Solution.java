package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
Инициализируйте переменную Statics.FILE_NAME полным путем к файлу с данными,
который содержит несколько строк.
После этого в статическом блоке считайте из файла
с именем Statics.FILE_NAME все строки,
и добавьте их по отдельности в List lines.

Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными,
который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME
все строки и добавь их по отдельности в List lines.


Требования:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME
должны быть добавлены по-отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            // https://habrahabr.ru/post/269667/
            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8);
            lines = Files.readAllLines(Paths.get(Statics.FILE_NAME));
            //Files.readAllBytes(Paths.get(Statics.FILE_NAME));

            Files.lines(Paths.get(Statics.FILE_NAME)).forEach(lines::add);

            File file = new File(Statics.FILE_NAME);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String s;
            while ((s = reader.readLine()) != null){
                lines.add(s);
            }
            reader.close();


            try (BufferedReader reader1 = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Statics.FILE_NAME), StandardCharsets.UTF_8))){
                String line;
                while ((line = reader1.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}

/*public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
}*/
