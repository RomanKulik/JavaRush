package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 

Класс ConsoleReader

Сегодня студенты секретного центра JavaRush получили задание по чтению.
Им (и вам) нужно создать класс ConsoleReader с 4 статическими методами: один из них считывает с клавиатуры строку,
другой — целое число, третий — дробное. Четвертый отличается: он считывает с клавиатуры строку true или false и
возвращает соответствующую логическую переменную.

Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку «true» или «false» и возвращает соответствующую логическую переменную true или false

Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода.


Требования:
1. Метод readString должен считывать и возвращать строку(тип String).
2. Метод readInt должен считывать и возвращать число(тип int).
3. Метод readDouble должен считывать и возвращать дробное число(тип double).
4. Метод readBoolean должен считывать и возвращать логическую переменную(тип boolean).
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        return getString();
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        return Integer.parseInt(getString());
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        return Double.parseDouble(getString());
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        return Boolean.parseBoolean(getString());
    }

    public static String getString() throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)).readLine();
        //String s = reader.readLine();
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static void main(String[] args) throws Exception {
       /* System.out.println(readString());
        System.out.println(readInt());
        System.out.println(readDouble());
        System.out.println(readBoolean());*/
    }
}


/*
public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код

    }

    public static int readInt() throws Exception {
        //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
*/
