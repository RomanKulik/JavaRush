package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*

Самые-самые

Игры со списками в Java очень популярны.
А всё потому, что это просто и интересно. Присоединяйтесь!
В этой задачке создаем список строк. Затем — добавляем в него 10 строчек с клавиатуры.
Самое интересное — определяем, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, учитываем самые первые из них.

Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int min = strings.get(0).length();
        int max = min;

        for (int i = 1, next; i < strings.size(); i++) {
            next = strings.get(i).length();
            max = max < next ? next : max;
            min = min > next ? next : min;
        }

        for (int i = 0, lenght; i < strings.size(); i++) {
            lenght = strings.get(i).length();
            if (lenght == min || lenght == max) {
                System.out.println(strings.get(i));
                break;
            }
        }
    }
}
