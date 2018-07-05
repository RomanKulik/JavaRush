package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*

В убывающем порядке

Упорядоченые изоморфы с планеты Линейный Хаос
любят сортировать и принимают в свои ряды тех, кто хорошо умеет это делать.
Вы можете возразить, что не собираетесь иметь с ними дело.
Не получится: изоморфы часто проводят собеседования в ИТ-компании.
Не игнорируем:
пишем программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.

В убывающем порядке
Задача: Написать программу,
которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.


Требования:
1. Программа должна считывать 20 целых чисел с клавиатуры.
2. Программа должна выводить 20 чисел.
3. Метод main должен вызывать метод sort.
4. Метод sort должен сортировать переданный массив по убыванию.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];

        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        /*if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }*/
    }
}
