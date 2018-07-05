package com.javarush.task.task09.task0922;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.*;

/*

Какое сегодня число?

В Java есть много инструментов, позволяющих работать со временем и датами.
В этот раз будем пользоваться объектом Date и SimpleDateFormat, а задание у нас такое:
пользователь должен ввести с клавиатуры дату в формате «08/18/2013»,
а приложение должно трансформировать введенное в форму «AUG 18, 2013».

Какое сегодня число?
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Все переменные должны быть проинициализированы.
5. Программа должна выводить данные на экран.
6. Вывод должен соответствовать заданию.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        // http://www.seostella.com/ru/article/2012/02/05/formatirovanie-daty-v-java.html
        Scanner scanner = new Scanner(System.in);
        final String dateS = scanner.nextLine();

        SimpleDateFormat oldDate = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat newDate = new SimpleDateFormat("MMM dd, yyyy", new Locale("US"));

        Date date = oldDate.parse(dateS);
        String dateRes = newDate.format(date).toUpperCase();

        System.out.println(dateRes);

        //Ввести с клавиатуры дату в формате «08/18/2013»
        //Вывести на экран эту дату в виде «AUG 18, 2013».

        LocalDate dateN = LocalDate.parse(dateS, DateTimeFormatter.ofPattern("MM/dd/yyy"));
        DateTimeFormatter d = DateTimeFormatter.ofPattern("MMM dd, yyyy", new Locale("en"));
        System.out.println(dateN.format(d).toUpperCase());

    }
}

/*
public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

    }
}*/
