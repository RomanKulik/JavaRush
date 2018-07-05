package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.List;

/*
Иногда задание — это просто задание.
Без подвоха, и не стоит искать в нём сложности и глубины.
Нужно просто сесть и решить.
Перед нами — именно такое задание.
Смотрите, как все внятно и просто: создайте массив, элементами которого будут списки строк.
А потом заполните массив любыми данными и выведите их на экран.

Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.


Требования:
1. Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList.
2. Метод createList должен возвращать созданный массив.
3. Метод createList должен добавлять в массив элементы (списки строк).
    Списки должны быть не пустые.
4. Программа должна выводить данные на экран.
5. Метод main должен вызывать метод createList.
6. Метод main должен вызывать метод printList.
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] lists = new ArrayList[5];
        for (int i = 0; i < lists.length; i++) {
            ArrayList<String> strings = new ArrayList<>();
            for (int j = 6; j < 11; j++) {
                strings.add(String.valueOf(j));
            }
            lists[i] = strings;
        }
        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        return null;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}*/
