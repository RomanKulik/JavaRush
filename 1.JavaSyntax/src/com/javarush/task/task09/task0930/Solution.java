package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*

Задача по алгоритмам

Вместо кубиков жители планеты Линейный Хаос дают своим детям решать задачки на сортировку.
Вот вам одна из забавок маленьких упорядоченных изоморфиков, развлекитесь, как следует:
после того, как пользователь введет с клавиатуры список слов (и чисел),
программа должна вывести слова в возрастающем порядке, а числа — в убывающем.

Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа — в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию.
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        while (true) {
            String s = reader.readLine();
            if (s.isEmpty())
                break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<Integer> stringIndex = new ArrayList<>();
        ArrayList<Integer> intIndex = new ArrayList<>();
        ArrayList<Integer> intData = new ArrayList<>();
        ArrayList<String> stringData = new ArrayList<>();

        int arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            if (isNumber(array[i])) {
                intIndex.add(i);
                intData.add(Integer.valueOf(array[i]));
            } else {
                stringIndex.add(i);
                stringData.add(array[i]);
            }
        }

        Collections.sort(intData);
        Collections.reverse(intData);
//        Collections.sort(stringData);
        Collections.sort(stringData, new Comparator<String>(){
            public int compare(String s1, String s2){
                return isGreaterThan(s1, s2)? 1 : -1;
            }
        });


        int j = 0;
        for (int i:
             intIndex) {
            array[i] = String.valueOf(intData.get(j++));
        }

        j = 0;
        for (int i:
             stringIndex) {
            array[i] = stringData.get(j++);
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0)
            return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) {// не цифра и не начинается с '-'
                return false;
            }
        }
        return true;
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}*/
