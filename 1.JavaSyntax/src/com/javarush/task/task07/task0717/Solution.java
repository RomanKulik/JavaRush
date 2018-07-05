package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*

Удваиваем слова

Пишем программу-эхо. Она удваивает всё, что слышит.
Вернее всё, что попало в список из 10 строк.
Для этого в программе-эхо создаем, собственно список из 10 слов
(вводим с клавиатуры строки и заносим их в список) и
метод doubleValues, который, собственно, удваивает слова по определенному принципу.
Результат эхо выводим на экран. Ничего сложного.

Удваиваем слова
1. Введи с клавиатуры 10 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Выведи результат на экран, каждое значение с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Метод doubleValues должен удваивать элементы списка по принципу a,b,c -> a,a,b,b,c,c..
4. Выведи получившийся список на экран, каждый элемент с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        result = doubleValues(list);

        // Вывести на экран result
        for (String s:
             result) {
            System.out.println(s);
        }

        //System.out.println(doubleString(reader.readLine()));
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            strings.add(list.get(i));
            strings.add(list.get(i));
        }

        return strings;
    }

    public static String doubleChars(String str) {
        int strLen = str.length();
        char[] charactersStr = new char[strLen];
        char[] chars = new char[strLen * 2];
        charactersStr = str.toCharArray();

        for (int i = 0, j = 0; i < strLen; i++) {
            chars[j] = charactersStr[i];
            chars[j + 1] = charactersStr[i];
            j += 2;
        }

        return new String(chars);
    }
}
