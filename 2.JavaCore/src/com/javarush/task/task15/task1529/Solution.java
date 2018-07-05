package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
Cоздадим классы Plane и Helicopter, реализующие интерфейс Flyable,
после чего в статическом методе reset класса Solution
нужно считать с консоли параметр типа String
и если он равен helicopter (plane),
то статическому объекту Flyable result присвоить объект класса Helicopter (Plane).
В статическом блоке инициализировать Flyable result вызвав метод reset.

Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь конструктор
с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен "helicopter",
то статическому объекту Flyable result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane",
то считать второй параметр типа int(количество пассажиров),
статическому объекту Flyable result присвоить объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
5. Закрыть поток ввода методом close().


Требования:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс Flyable.
2. Класс Helicopter должен быть создан в отдельном файле
и реализовывать интерфейс Flyable.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован статический метод reset.
5. Метод reset должен считывать строку с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result
должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result
должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано
в статическом блоке путем вызова метода reset.
*/
public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        Scanner scanner = new Scanner(System.in);
        String s;
        try {
            s = scanner.nextLine();
            if (s.equals("helicopter"))
                result = new Helicopter();
            else if (s.equals("plane")) {
                s = scanner.nextLine();
                result = new Plane(Integer.parseInt(s));
            }
        } catch (Exception e){
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут

    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут

    }
}*/
