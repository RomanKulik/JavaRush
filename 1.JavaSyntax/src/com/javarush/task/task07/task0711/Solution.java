package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*

Удалить и вставить

Манипулировать списками в Java — почти так же легко и приятно, как людьми!
Ладно, сейчас о списках.
Вот что нужно сделать: создать список, добавить в него 5 строк.
Затем удалить последнюю строку и вставить её в начало.
Повторить манипуляцию 13 раз и вывести на экран содержимое списка.
Зачем? Не задавайтесь этим вопросом, просто поверьте: так нужно.

Удалить и вставить
1. Создай список строк.
2. Добавь в него 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и добавлять их в список.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Программа должна выводить список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int lastIndexInArrStrings = strings.size() - 1;

        for (int i = 0; i < 13; i++) {
            String str = strings.get(lastIndexInArrStrings);
            strings.remove(lastIndexInArrStrings);
            strings.add(0, str);
        }

        for (String s:
             strings) {
            System.out.println(s);
        }
    }
}
