package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Нам поступило новое детское задание от упорядоченных изоморфов с планеты Линейный Хаос.
Вы ещё помните, что именно эти странные ребята видумали все виды сортировки и постоянно в ней упражняются.
Поэтому и задания такие странные, зацените: ввести с клавиатуры 30 чисел.
Вывести 10-е и 11-е минимальные числа.
Хотя… Надо попробовать!

Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел.
Вывести 10-е и 11-е минимальные числа.
Пояснение:
Самое минимальное число – 1-е минимальное.
Следующее минимальное после него – 2-е минимальное

Пример:
1 6 5 7 1 15 63 88
Первое минимальное – 1
Второе минимальное – 1
Третье минимальное – 5
Четвертое минимальное – 6


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Класс Solution должен содержать два метода.
4. Метод sort() должен сортировать массив элементов.
5. Метод main() должен вызывать метод sort().
6. Программа должна выводить 10-е и 11-е минимальные числа. Каждое значение с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
       /* for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }*/

        int[] arr = new int[]{5, 4, 3, 1, 2};
        sortMergeNoRecursive(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        Arrays.sort(array);
    }



    //sortMerge
    private static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2)
            return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static void sortMergeNoRecursive(int[] arr) {
        int len = arr.length;
        int n = 1; // кратность сравнений (сравнивать по 1-му елем., 2-м ...)
        int shift; // сдвиг в перебираемом массиве
        int two_size; // количество елементов для 2-го массива
        int[] arr2;
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + two_size));
                for (int i = 0; i < n + two_size; ++i)
                    arr[shift + i] = arr2[i]; // замена на отсортированное
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
    // end of sortMerge
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
    }
}*/
