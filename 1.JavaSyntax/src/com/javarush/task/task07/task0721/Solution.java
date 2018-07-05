package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*

Минимаксы в массивах

В жилмассиве Трещина — всего 20 домов, но их номера проставляются от фонаря.
Получается, конец и начало Трещины формируются случайным образом.
Потому как так интереснее и непредсказуемее!
Пишем мини-эмулятор Трещины: определим его начало и конец.
Для этого запихнем жилмассив в массив, заполним его номерами домов,
и найдем среди них наибольший и наименьший.

Минимаксы в массивах
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.


Требования:
1. Создай массив целых чисел (int[]) на 20 элементов.
2. Считай с клавиатуры 20 целых чисел и добавь их в массив.
3. Найди и выведи через пробел максимальное и минимальное числа.
4. Используй цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[20];

        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(array);

        int maximum = array[19];
        int minimum = array[0];

        for (int number : array) {

            if (maximum < number) {
                maximum = number;
            } else if (minimum > number) {
                minimum = number;
            }

        }


        System.out.print(maximum + " " + minimum);
    }
}
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr = new int[20];
        int maximum = arr[0];
        int minimum = arr[0];

        for (int i = 1, next; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            */
/*next = arr[i];
            maximum = maximum < next ? next : maximum;
            minimum = minimum > next ? next : minimum;*//*

        }

        Arrays.sort(arr);

        maximum = arr[19];
        minimum = arr[0];

        //System.out.println(maximum + "\n" + minimum);
        System.out.println(maximum);
        System.out.println(minimum);

        //напишите тут ваш код
        */
/*for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }

        maximum = Collections.max(arrayList);
        minimum = Collections.min(arrayList);*//*



    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        int maximum;
        int minimum;

        //напишите тут ваш код
    }
}*/
