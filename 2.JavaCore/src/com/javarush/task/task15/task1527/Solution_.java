package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов

Считайте с консоли URL-ссылку.
Затем выведите на экран через пробел список всех параметров (
Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передайте его значение в нужный метод alert.

Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров
(Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то,
что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае,
если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае,
если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/
/*public class Solution_ {
    static List<String> params = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            parser(reader.readLine());
        } catch (IOException e) {
        } finally {
            reader.close();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static void parser(String url) {
        //System.out.println("parser");
        if (url == null)
            return;

        // выделяет строку запроса из URL
        String request = url.substring(url.indexOf("?") + 1);
        //System.out.println(request);

        fillParamList(request);
        //params.forEach(param -> System.out.printf("%s ", param));
        System.out.println();
        callStringDoubleAlert(request);
    }

    private static void fillParamList(String request) {
        //System.out.println("fillParamList");
        // Условие выхода из рекурсии - определение последнего параметра, за которым больше нет '&'
        if (request.indexOf("&") == -1) {
            if (request.indexOf("=") >= 0) // Если последний параметр содержит '=', добавить List все, что до '='
                //params.add(request.substring(0, request.indexOf('=')));
                System.out.print(request.substring(0, request.indexOf('=')));
            else
                //params.add(request);
                System.out.print(request);
            return;
        }

        // подстрока первого параметра в строке запроса без '&'
        String ampersandSubstring = request.substring(0, request.indexOf('&'));

        if (ampersandSubstring.indexOf('=') >= 0)
            *//*params.add(ampersandSubstring.substring(0,
                    ampersandSubstring.indexOf('=')));*//*
            System.out.print(ampersandSubstring.substring(0,
                    ampersandSubstring.indexOf('=')) + " ");
        else
            //params.add(ampersandSubstring);
            System.out.print(ampersandSubstring + " ");

        // рекурсивный вызов, параметр - request, за вычетом первого параметра ampersandSubstring
        fillParamList(request.substring(ampersandSubstring.length() + 1));
    }

    private static void callStringDoubleAlert(String request) {
        //System.out.println("callStringDoubleAlert");
        if (request.contains("obj")) {
            String number = request.substring(request.indexOf("obj=") + 4,
                    request.indexOf("&")
            );
            //System.out.println(number);

            try {
                alert(Double.parseDouble(number));
            } catch (Exception e) {
                alert(number);
            }
        }
    }
}*/
/*public class Solution {
    public static void main(String[] args) {
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}*/
