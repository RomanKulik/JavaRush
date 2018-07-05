package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 

Числа по возрастанию

Возможно, вы уже слышали об упорядоченных изоморфах с планеты Линейный Хаос — изобретателях всех методов сортировки.
Сегодня нужно решить задачу от них: пользователь вводит с клавиатуры 5 чисел, метод сортирует числа по возрастанию,
а другой метод — выводит их на экран. Осилите? Если да, возможно, вам следует посетить Линейный Хаос!

Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

Пример ввода:
3
2
15
6
17

Пример вывода:
2
3
6
15
17

Требования:
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // var 1
        int size = 5;
        //ArrayList<Integer> arraylist = new ArrayList<Integer>();
        ArrayList arr = new ArrayList();

        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(arr);

        for (Object counter:
             arr) {
            System.out.println(counter);
        }

        // var 2
       /* int size = 5;
        int[] mas = new int[size];

        //напишите тут ваш код
        for (int i = 0; i < size; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        int ii = 0;
        for (int j = 0, tmp = 0; ii < size * size; ++ii) {
            if (j == size - 1) {
                j = 0;
            }
            if (mas[j] > mas[j + 1]) {
                tmp = mas[j + 1];
                mas[j + 1] = mas[j];
                mas[j] = tmp;
            }
            j++;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(mas[i]);
        }*/
    }
}
