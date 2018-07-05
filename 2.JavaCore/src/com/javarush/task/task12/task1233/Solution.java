package com.javarush.task.task12.task1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Изоморфы наступают
Раз мы говорим об упорядоченных изоморфах с планеты Линейный Хаос, значит,
мы собираемся решать задачу на знание алгоритмов.
Ибо изоморфы без алгоритмов — не изоморфы вовсе.
Да и не станут они разговаривать с человеком или роботом,
который не может найти минимум в массиве и его позицию.
Но вы-то — сможете?

Изоморфы наступают
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).


Требования:
1. Класс Solution должен содержать класс Pair.
2. Класс Solution должен содержать два метода.
3. Класс Solution должен содержать метод getMinimumAndIndex().
4. Метод getMinimumAndIndex() должен возвращать минимальное число в массиве и его позицию (индекс).
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код
        //sortBubble(array);
        //sortFull(array);
        //return new Pair<Integer, Integer>(sortBubble(array), getMinIndex(array, sortBubble(array)));

        int[] arrCopy = array.clone();
        Arrays.sort(arrCopy);

        int min = arrCopy[0];
        int index = 0;

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == min) {
                index = i;
                break;
            }
        }

        /*for (int i=0; i<array.length; i++){
            if (min > array[i]) {
                min = array[i];
                index = i;
            }
        }*/

        return new Pair<Integer, Integer>(min, index);
    }

    /*public static int getMinIndex(int[] array, int minValue) {
        int index = 0;

        if(array == null || array.length == 0) return 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == minValue) {
                index = i;
                break;
            }
        }
        System.out.println("Index = " + index);
        return index;
    }*/

    /*public static int sortBubble(int[] arr) {
        int[] array;
        array = Arrays.copyOf(arr, arr.length - 1);
        //array = arr.clone();

        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        // System.out.println(arr[0]);
        //System.out.println(array[0]);
        return array[0];
    }*/

    /*public static int sortFull(int[] array) {
        int[] arr = new int[array.length - 1];
        System.arraycopy(array, 0, arr, 0, array.length - 1);
        int count = 0;

        for (int i = 0, len = arr.length - 1; i < len; ) {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
            count++;
        }

        *//*System.out.println(count);

        for (int i : arr) {
            System.out.print(i);
        }*//*
        return arr[0];
    }*/

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

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код

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
