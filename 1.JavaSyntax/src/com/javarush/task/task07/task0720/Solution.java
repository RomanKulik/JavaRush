package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Перестановочка подоспела

Игры со списками — лучшее времяпрепровождение!
Реклама так себе получается?
Пожалуй, лучшая реклама средства языка программирования — его частое применение.
Рекламируем списки, решая задачу:
задаем числа m и n, печатаем n строк и заполняем ими список.
После этого совершаем незатейливую манипуляцию:
переставляем m первых строк в конец списка

Перестановочка подоспела
Ввести с клавиатуры 2 числа N и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.

Примечание: запрещено создавать больше одного списка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай c клавиатуры числа N и M, считай N строк и добавь их в список.
3. Переставить M первых строк в конец списка.
4. Выведи список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            strings.add(reader.readLine());
        }

        /*for (int i = 0; i < M; i++) {
            strings.add(strings.get(i));
            //strings.remove(0);
        }*/
        Collections.rotate(strings, N - M);
        //Collections.rotate(strings, -1);

        for (String s:
             strings) {
            System.out.println(s);
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
    }
}
*/
