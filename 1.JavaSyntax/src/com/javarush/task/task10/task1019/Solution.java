package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.K;

/*
Старая задача: с клавиатуры вводятся пары (число и строка), затем они выводятся на экран.
Новая задача: вводим с клавиатуры те же пары, сохраняч их в HashMap.
Пустая строка – конец ввода данных. Числа могут повторяться, а строки — нет.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран, каждую пару с новой строки.

Функциональности маловато!
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка – конец ввода данных.
Числа могу повторяться.
Строки всегда уникальны.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.
Каждую пару с новой строки.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. В методе main объяви переменную коллекции HashMap и сразу проинициализируй ee.
4. Программа должна помещать в HashMap пары считанные с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap согласно условию.
Ключ и значение разделены пробелом. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            try {
               /* int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                map.put(name, id);*/
                String s = reader.readLine();
                if (s.equals(""))  break;

                map.put(reader.readLine(),Integer.parseInt(s));
            } catch (Exception e) {
                break;
            }
        }

        map.forEach((s, integer) -> System.out.println(integer + " " + s));
    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int id = Integer.parseInt(reader.readLine());
        String name = reader.readLine();

        System.out.println("Id=" + id + " Name=" + name);
    }
}
*/
