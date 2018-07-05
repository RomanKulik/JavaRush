package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*

Играем в Jолушку

Игра Jолушка 1.0: распихиваиние чисел по трем спискам.
Правила таковы: Jолушка получила список из 20 чисел.
Ей нужно проверить, какие из них нацело делятся на 3, какие на 2, а какие — ни на то, ни на другое.
Затем ей нужно сохранить их в отдельные списки.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Решаем!

Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран.
Сначала тот, который для x%3, потом тот, который для x%2, потом последний.


Требования:
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList (список целых чисел).
Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> main = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            main.add(Integer.parseInt(reader.readLine()));
            //main.add(i + 1);
        }

        for (int i = 0, curNum; i < main.size(); i++) {
            curNum = main.get(i);
            /*if (curNum == 0) {
                arr.add(curNum);
            } else */
            if (curNum % 3 == 0 && curNum % 2 == 0) {
                arr3.add(curNum);
                arr2.add(curNum);
            } else if (curNum % 3 == 0) {
                arr3.add(curNum);
            } else if (curNum % 2 == 0) {
                arr2.add(curNum);
            } else {
                arr.add(curNum);
            }
        }

        printList(arr3);
        printList(arr2);
        printList(arr);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
    }
}
*/
