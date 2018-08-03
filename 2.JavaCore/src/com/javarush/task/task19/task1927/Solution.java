package com.javarush.task.task19.task1927;

import java.io.*;
import java.util.Arrays;

/*
Контекстная реклама
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу
после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле
testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки:
"first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток
PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать
поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод
printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать
строки(вставлять контекстную рекламу) выведенные методом printSomething()
согласно заданию, и выводить её в консоль.
*/
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream copyOut = System.out;
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ba));
        testString.printSomething();
        System.setOut(copyOut);
        String[] ss = ba.toString().split(System.lineSeparator());
        int count = 0;
        for (String s : ss) {
            if (count == 2) {
                System.out.println("JavaRush - курсы Java онлайн");
                count = 0;
            }
            System.out.println(s);
            count++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
/*public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}*/
