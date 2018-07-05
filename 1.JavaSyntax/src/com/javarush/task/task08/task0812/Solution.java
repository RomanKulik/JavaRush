package com.javarush.task.task08.task0812;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

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
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> integers = new ArrayList<>();
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            integers.add(i, Integer.parseInt(reader.readLine()));
        }
        //System.out.println(integers);

        int max = 1;
        int count = 1;

        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i).equals(integers.get(i + 1))) {
                count++;
            } else if (max < count) {
                max = count;
                count = 1;
            } else  {
                count = 1;
            }
        }

        System.out.println(max < count ? count : max);
    }


}