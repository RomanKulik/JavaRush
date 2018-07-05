package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*

Вывести числа в обратном порядке

Вы же знаете, что задачи можно решать разными способами?
Да конечно знаете.
Но в этой конкретной задаче мы попросим вас вспомнить о цикле for,
и совершать манипуляции именно с его помощью.
А сделать нужно вот что: ввести с клавиатуры 10 чисел, заполнить ими список,
а затем — вывести их в обратном порядке.

Вывести числа в обратном порядке
Ввести с клавиатуры 10 чисел и заполнить ими список.
Вывести их в обратном порядке.
Использовать только цикл for.


Требования:
1. Объяви переменную типа список целых чисел и сразу проинициализируй ee.
2. Считай 10 целых чисел с клавиатуры и добавь их в список.
3. Выведи числа в обратном порядке.
4. Используй цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> ints = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            ints.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(ints.get(9 - i));
        }
    }
}
