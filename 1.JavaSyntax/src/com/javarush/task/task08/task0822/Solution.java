package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*

Минимальное из N чисел

Программист ищет минимумы и максимумы везде,
где может — среди двух чисел, в массиве, в списке…
На восьмом уровне секретного центра JavaRush студенты изучают списки, поэтому этот важный момент наступил.
Прямо сейчас можно попробовать найти минимум в списке из n чисел.
Но прежде, чем искать минимум, нужно этот список сформировать.
Вы еще здесь?

Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список — метод getIntegerList.
3. Найти минимальное число среди элементов списка — метод getMinimum.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод getIntegerList() должен считать с клавиатуры число N,
потом вернуть список размером N элементов, заполненный числами с клавиатуры.
5. Метод getMinimum() должен вернуть минимальное число среди элементов списка.
6. Метод main() должен вызывать метод getIntegerList().
7. Метод main() должен вызывать метод getMinimum().
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        return  Collections.min(array);
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        List<Integer> integers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int number = Integer.parseUnsignedInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            integers.add(Integer.parseInt(reader.readLine()));
        }

        return integers;
    }
}
