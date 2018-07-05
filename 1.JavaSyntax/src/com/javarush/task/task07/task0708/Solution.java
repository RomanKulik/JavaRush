package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

Самая длинная строка

Давайте померяемся строками!
А заодно и задачку решим по программированию: создадим список строк,
считаем с клавиатуры 5 штук и добавим их в список.
Затем с помощью цикла найдем из списка самую длинную строку (или несколько, если она такая не одна).
Страна должна знать своих героев: самые длинные строки будут выведены на экран.

Самая длинная строка
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Инициализируй поле класса новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список strings.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int max = strings.get(0).length();

        for (int i = 1, next = 0; i < strings.size(); i++) {
            next = strings.get(i).length();
            max = max < next ? next : max;
        }

        for (int i = 0, length = 0; i < strings.size(); i++) {
            length = strings.get(i).length();
            if (length == max) {
                System.out.println(strings.get(i));
            }
        }
    }
}
