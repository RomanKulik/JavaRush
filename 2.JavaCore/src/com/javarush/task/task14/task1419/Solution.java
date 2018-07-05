package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.BufferOverflowException;
import java.util.*;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.

Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.

Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.



*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }
    public static int getAreaValue(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException();

        return x * y;
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int arr[] = new int[3];
            int s = arr[4];

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            List<Integer> integers = new ArrayList<>();
            int n = 5 / integers.get(4);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "bb";
            System.out.println(s.charAt(4));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            s.toUpperCase();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
           FileReader f = new FileReader("hh.uu");

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Scanner c = new Scanner(System.in);
            c.nextInt();

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] p =  new int[-2];
            p[-3]=5;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int result = getAreaValue(-1, 100);

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
           throw new BufferOverflowException();

        } catch (Exception e) {
            exceptions.add(e);
        }

    }

}
