package com.javarush.task.task06.task0611;

/* 

Класс StringHelper

Мы любим статические методы, они делают недоступное доступным.
Хотя порой и наоборот… Но в этой задаче мы их любим:
нам необходимо создать класс StringHelper,
у которого будут 2 статических метода.
Это multiply(String s, int count) – возвращает строку,
повторенную count раз и multiply(String s) – возвращает строку, повторенную 5 раз.

Класс StringHelper
Сделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) – возвращает строку повторенную count раз.
String multiply(String s) – возвращает строку повторенную 5 раз.

Пример:
Амиго -> АмигоАмигоАмигоАмигоАмиго


Требования:
1. Методы класса StringHelper должны возвращать строку.
2. Методы класса StringHelper должны быть статическими.
3. Методы класса StringHelper должны быть public.
4. Метод multiply(String s, int count) должен возвращать строку повторенную count раз.
5. Метод multiply(String s) должен возвращать строку повторенную 5 раз.
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        for (int i = 0; i < 5; i++, result += s ) {}
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        for (int i = 0; i < count; i++) {
            result = result.concat(s);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(multiply("Java"));
//        System.out.println(multiply("Java", 3));
    }
}

/*
public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {
    }
}*/
