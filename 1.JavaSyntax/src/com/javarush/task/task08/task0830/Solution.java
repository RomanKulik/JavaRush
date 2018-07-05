package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*

Задача по алгоритмам

Вероятно, вы уже знаете упорядоченных изоморфов с планеты Линейный Хаос,
которые любят алгоритмы сортировки, поскольку ими думают.
Вот вам задачка для изоморфов младшего школьного возраста:
введите с клавиатуры 20 слов и выведите их в алфавитном порядке.
А как сортировать? Придумайте, вы уже почти что линейный изоморф!

Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать три метода.
4. Метод main() должен вызывать метод sort().
5. Метод sort() должен вызывать метод isGreaterThan().
6. Выведенные слова должны быть отсортированы в алфавитном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        int count = 0;
        //Arrays.sort(array);
       /* for (int i = 0, j = 0; j < Math.pow(array.length, 2); j++,i++) {
            if (i == array.length - 1)
                i = 0;
            if (isGreaterThan(array[i], array[i + 1])) {
                String s = array[i];
                array[i] = array[i + 1];
                array[i + 1] = s;
            }
            count++; // 100
        }*/

        // Перестановками
        String max = null;
        for (int i = 1; i < array.length; ) {
            if (isGreaterThan(array[i-1], array[i])) {
                max = array[i];
                array[i] = array[i-1];
                array[i-1] = max;
                if (i != 1) {
                    i--;
                }
            } else {
                i++;
            }
            count++; // 58
        }

        //Bubble sort
        String surrender = null;
        for (int i = array.length-1; i > 0;i--) {
            for (int j = 0; j < i; j++) {
                if (isGreaterThan(array[j], array[j + 1])) {
                    surrender = array[j];
                    array[j] = array[j+1];
                    array[j+1] = surrender;
                }
                count++; // 45
            }
        }
        System.out.println("Count = " + count);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {

        return a.compareTo(b) > 0;
    }
}
