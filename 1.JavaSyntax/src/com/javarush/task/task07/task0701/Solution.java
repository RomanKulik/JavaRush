package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 

Массивный максимум

На сегодняшнем соревновании приз за лучший результат получает Кентербери!
Он автоматизировал 25 процессов, все его 19 сокурсников оказались менее быстры.
Давайте напишем программу, которая помогла бы определять победителя таких соревнований:
составляем массив на 20 элементов, заполняем его числами и находим максимальное из них.

Массивный максимум
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива


Требования:
1. Метод initializeArray должен создавать массив из 20 целых чисел.
2. Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.
3. Метод max должен возвращать максимальный элемент из переданного массива.
4. Метод main изменять нельзя.
*/

public class Solution {
    static int size = 20;
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        int[] array = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = max < array[i] ? array[i] : max;
        }

        return max;
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        return null;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        return 0;
    }
}
*/
