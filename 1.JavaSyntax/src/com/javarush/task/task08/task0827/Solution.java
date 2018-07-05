package com.javarush.task.task08.task0827;

import java.util.Date;

/*

Работа с датой

Станция Небула-1 принимает звездолёты только по нечётным дням стандартного
земного года (когда количество дней с начала года — нечётно).
Выясним, можем ли мы сегодня отдохнуть на Небуле-2.
Для этого реализуем метод isDateOdd(String date), возвращающий true,
если количество дней с начала года — нечётное число, иначе false.

Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года — нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true,
если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) {
        Date dateIn = new Date(date);

        String newYear = "JANUARY 1 ";
        newYear += dateIn.getYear();
        Date newYearDate = new Date(newYear);

        long res = (dateIn.getTime() - newYearDate.getTime()) / 1000 / 60 / 60 / 24;

        return res % 2 == 0;
    }
}

/*
public class Solution {
    public static void main(String[] args) {

        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        return true;
    }
}
*/
