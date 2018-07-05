package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
Итак, полиморфизм. Вы о нём ещё не забыли?
Тогда решаем следующую задачку:
считываем с консоли данные, пока не будет введено слово "exit".
Для каждого значения, кроме "exit", вызываем метод print,
какой именно принт — зависит от значения.
Например, если значение содержит точку, то вызываем print для Double,
а если это число от 0 до 128 — то для short.

Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print.
Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. меньше либо равно нулю или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.

Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна прекращать считывать данные с клавиатуры
после того как была введена строка "exit".
3. Если введенная строка содержит точку(".")
и может быть корректно преобразована в число
типа Double - должен быть вызван метод print(Double value).
4. Если введенная строка может быть корректно преобразована
в число типа short и полученное число больше 0,
но меньше 128 - должен быть вызван метод print(short value).
5. Если введенная строка может быть корректно преобразована
в число типа Integer и полученное число меньше или равно 0
или больше или равно 128 - должен быть вызван метод print(Integer value).
6. Во всех остальных случаях должен быть вызван метод print(String value).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
/*
        while (!((str = reader.readLine()).equals("exit"))) {
            if (!(str.matches("-?\\d+") || str.matches("-?\\d+\\.\\d+")))
                print(str); // String
            else {
                if (str.contains(".")) {
                    print(Double.parseDouble(str)); // Double
                    continue;
                }

                short sh = Short.parseShort(str);
                if (sh > 0 && sh < 128)
                    print((short) sh); // short
                else
                    print(Integer.parseInt(str)); // Integer
            }
        }
*/


        while (!((str = reader.readLine()).equals("exit"))) {
            try {
                if (str.contains(".")) {
                    print(Double.parseDouble(str));
                    continue;
                }

                Integer integer = Integer.parseInt(str);
                if (integer <= 0 || integer >= 128) {
                    print(integer);
                    continue;
                }

                short sh = Short.parseShort(str);
                if (sh > 0 && sh < 128) {
                    print((short) sh);
                    continue;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            print(str);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
/*public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}*/
