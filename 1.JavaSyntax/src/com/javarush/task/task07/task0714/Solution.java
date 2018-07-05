package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*

Слова в обратном порядке

Если половина или больше ваших действий вам кажутся лишёнными смысла, не переживайте:
скорее всего, вы чётко осознаете бренность бытия,
а, значит, можете стать классным программистом.
И еще: иногда — просто кажется.
Здесь есть смысл: введите 5 слов, поместите их в список.
Удалите третий элемент списка, и выводите оставшиеся элементы в обратном порядке.

Слова в обратном порядке
Введи с клавиатуры 5 слов в список строк.
Удали 3 — ий элемент списка, и выведи оставшиеся элементы в обратном порядке.


Требования:
1. Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
2. Считай 5 строк с клавиатуры и добавь их в список.
3. Удали третий элемент массива.
4. Выведи элементы на экран, каждый с новой строки.
5. Порядок вывода должен быть обратный.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        strings.remove(2);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(strings.size() - i - 1));
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    }
}
*/


