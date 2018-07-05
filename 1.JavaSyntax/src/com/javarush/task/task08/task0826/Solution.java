package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/*

Пять победителей

На корабле JRush прошёл многоэтапный конкурс по скоростному решению задач на массивы среди студентов 7-8 уровней.
Среди 20 полуфиналистов пятеро с максимальными баллами считаются победителями.
Итак, у нас есть массив с баллами полуфиналистов (баллы могут быть даже отрицательными).
Выведем на экран великолепную пятёрку победителей.

Пять победителей
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Вывести пять наибольших чисел.
Каждое значение с новой строки.


Требования:
1. Программа должна выводить числа на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать два метода.
4. Метод sort() должен сортировать массив чисел от большего к меньшему.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить пять наибольших чисел массива. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[100000000];
        /*for (int i = 0; i < array.length; i++) {
            //array[i] = Integer.parseInt(reader.readLine());
            array[i] = array.length - i - 1;
        }*/

        long res = 0;
        int count = 100;
        Date dStart;
        Date dFin;

        for (int i = 0; i < count; i++) {
            getIntArray(array);
            Arrays.sort(array);
            dStart = new Date();
            sort(array);
            dFin = new Date();
            res += dFin.getTime() - dStart.getTime();
        }
        System.out.println("sort =\t\t\t" + (res / count) + " ms"); //327, 208 ms

        res = 0;
        for (int i = 0; i < count; i++) {
            getIntArray(array);
            Arrays.sort(array);
            dStart = new Date();
            reverseArray(array);
            dFin = new Date();
            res += dFin.getTime() - dStart.getTime();
        }
        System.out.println("reverseArray =\t" + (res / count) + " ms"); //318, 216 ms

        res = 0;
        for (int i = 0; i < count; i++) {
            getIntArray(array);
            Arrays.sort(array);
            dStart = new Date();
            reverseArray2(array);
            dFin = new Date();
            res += dFin.getTime() - dStart.getTime();
        }
        System.out.println("reverseArray2 =\t" + (res / count) + " ms"); // 328, 118 ms


        /*System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);*/


    }

    public static int[] getIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //array[i] = Integer.parseInt(reader.readLine());
            array[i] = array.length - i - 1;
        }

        return array;
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        //Arrays.sort(array);

        //int len = array.length;
        /*int[] arr = Arrays.copyOf(array, len);

        for (int i = 0, j = len; i < len; i++) {
            array[i] = arr[--j];
        }*/

        for(int i = 0; i < array.length / 2; i++)
        {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    public static void reverseArray (int[] array) {
        //Arrays.sort(array);
        for(int i = 0, len = array.length, divl = len / 2, temp; i < divl; i++) {
            temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
    }
    public static void reverseArray2 (int[] array) {
        //Arrays.sort(array);
        for(int i = 0, len = array.length; i < len / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
