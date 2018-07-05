package com.javarush.task.task11.task1123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*На вступительном экзамене в ясли упорядоченному изоморфу Васеньке с планеты Линейный Хаос
задали задачку на нахождение максимума и минимума в массиве. Как вы помните (или нет),
на этой планете все только и заняты упорядочиванием и сравнением.
Васенька справился. А вы?

Минимакс
Написать метод, который возвращает минимальное и максимальное числа в массиве.

Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Допиши реализацию метода getMinimumAndMaximum, он должен возвращать пару из минимума и максимума.
3. Метод main не изменять.
4. Программа должна вывести правильный результат.
5. Метод main должен вызывать метод getMinimumAndMaximum.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //Напишите тут ваше решение
        //Arrays.sort(array);
        //return new Pair<Integer, Integer>(array[0], array[array.length - 1]);

       /* int min = array[0];
        int max = array[0];

        for (int i = 1, len = array.length - 2; i < len; i++) {
            int tmp = array[i];
            if (min > tmp)
                min = tmp;
            if (max < tmp)
                max = tmp;
        }

        return new Pair<>(min, max);*/

       return new Pair<Integer, Integer>(Arrays.stream(array).min().getAsInt(), Arrays.stream(array).max().getAsInt());
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //Напишите тут ваше решение

        return new Pair<Integer, Integer>(0, 0);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}*/
