package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Random;

/*

Список из массивов чисел

К 9 уровню студенты уже отлично манипулируют массивами и кое-что знают о списках.
Объединим эти знания, попробуем сделать следующее задание.
Создадим список, элементами которого будут массивы чисел.
Затем добавим в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Напоследок заполним массивы любыми данными и выведем их на экран.

Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.


Требования:
1. Метод createList должен объявлять и инициализировать переменную типа ArrayList.
2. Метод createList должен возвращать созданный список.
3. Метод createList должен добавлять в список 5 элементов.
4. Каждый элемент в списке должен быть массивом чисел.
    Длина первого должна быть 5 элементов, второго - 2, следующих - 4, 7, 0 соответственно.
5. Программа должна выводить на экран элементы всех массивов из списка. Каждый элемент с новой строки.
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        /*ArrayList<int[]> ints = new ArrayList<int[]>();
        ints.add(new int[] {1, 3, 5, 7, 9});
        ints.add(new int[] {1, 3});
        ints.add(new int[] {1, 3, 5, 7});
        ints.add(new int[] {1, 3, 5, 7, 9, 11, 13});
        ints.add(new int[] {});

        return ints;*/
            /*ArrayList<int[]> list = new ArrayList<>();
           for (int i :
                    new int[]{5, 2, 4, 7, 0}) {
                list.add(new int[i]);
            }
            for (int[] i :
                    list) {
                for (int j = 0; j < i.length; j++) {
                    i[j] = j * j;
                }
            }*/
        ArrayList<int[]> list = new ArrayList<>();
        int[] arrLens = {5, 2, 4, 7, 0};

        for (int i = 0; i < arrLens.length; i++) {
            list.add(new int[arrLens[i]]);
            for (int j = 0; j < list.get(i).length; j++) {
                list.get(i)[j] = new Random().nextInt(100);
            }
        }

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}*/
