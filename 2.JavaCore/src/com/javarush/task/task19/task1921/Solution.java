package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List,
которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args.length == 0 ? "d:/1.txt" : args[0];
        try (BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
            while (fr.ready()) {
                String str = fr.readLine();

                String[] arrName = str.split("\\d{1,2} \\d{1,2} \\d{4}");
                StringBuilder name = new StringBuilder();
                for (String s : arrName) {
                    name.append(s.trim()).append(" ");
                } //System.out.println("name: " + name);

                String[] arrBirth = str.split("\\W");
                StringBuilder birth = new StringBuilder();
                for (String s : arrBirth) {
                    if (s.length() > 0)
                        birth.append(s).append(" ");
                }//System.out.println(birth);

                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                Date date = sdf.parse(birth.toString());

                PEOPLE.add(new Person(name.toString().trim(), date));
            }
            PEOPLE.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
/*public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

    }
}*/
