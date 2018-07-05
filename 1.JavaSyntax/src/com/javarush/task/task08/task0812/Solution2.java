package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Cамая длинная последовательность

Если числа повторяются, значит, это кому-нибудь нужно?
В данный момент это нужно нам, чтобы потренироваться решать задачи на списки.
Давайте создадим список чисел и добавим в него 10 чисел с клавиатуры.
Наша задача состоит в том, чтобы вывести на экран длину
самой длинной последовательности повторяющихся чисел в списке.

Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности
повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность
повторяющихся чисел состоит из трех четверок.


Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа ArrayList с типом элементов
Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности
повторяющихся чисел в списке.
*/
public class Solution2 {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            integers.add(i, Integer.parseInt(reader.readLine()));
        }
        //System.out.println(integers);

        System.out.println(getFrequency(integers));
        //System.out.println(Collections.frequency(integers, 3));
    }

    public static Integer getFrequency(List<Integer> list) {
        int start = list.get(0);
        int numberCount = 0;
        int[] listInt = new int[list.size()];
        //System.out.println(listInt);

        for (int i = 1, next; i < list.size(); i++) {
            next = list.get(i);
            if (start == next) {
                listInt[numberCount] = (Integer)(listInt[numberCount] + 1);
            } else {
                listInt[numberCount] = (Integer)(listInt[numberCount] + 1);
                numberCount++;
            }
            start = next;
        }

        return findMaxInArray(listInt);
    }

    public static Integer findMaxInArray(int[] list) {
        if (list.length == 0) {
            //printArr(list);
            return 0;
        }

        Arrays.sort(list);
        //System.out.println(list[list.length - 1]);

        if (list[list.length - 1] == 1) {
            //printArr(list);
            return 0;
        } else {
            //printArr(list);
            return list[list.length - 1];
        }
    }

    public static void printArr(int[] arr) {
        System.out.print(arr[0]);

        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                System.out.print(", " + arr[i]);
            }
        }

        System.out.println();
    }
}