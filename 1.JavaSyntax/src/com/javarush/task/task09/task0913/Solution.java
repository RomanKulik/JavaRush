package com.javarush.task.task09.task0913;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/* 

Исключения. Просто исключения.

У нас есть метод. Он выбрасывает два исключения, унаследованные от Exception,
и два унаследованных от RuntimeException:
NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException.
Задание: перехват NullPointerException и FileNotFoundException,
без перехвата ArithmeticException и URISyntaxException.
Как это сделать?

Исключения. Просто исключения.
Есть метод, который выбрасывает два исключения, унаследованные от Exception, и два унаследованных от RuntimeException:
NullPointerException, ArithmeticException,
FileNotFoundException, URISyntaxException.

Нужно перехватить NullPointerException и FileNotFoundException, но не перехватывать
ArithmeticException и URISyntaxException.
Как это сделать?


Требования:
1. Метод main должен вызывать метод method1.
2. Метод main должен перехватывать исключение NullPointerException.
3. Метод main должен перехватывать исключение FileNotFoundException.
4. Метод main не должен перехватывать исключение ArithmeticException.
5. Метод main не должен перехватывать исключение URISyntaxException.
6. Метод method1 не изменять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try {
            method1();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } /*catch (ArithmeticException e) {
            e.printStackTrace();
        }*/ catch (FileNotFoundException e) {
            e.printStackTrace();
        } /*catch (URISyntaxException e) {
            e.printStackTrace();
        }*/

        //напишите тут ваш код
    }

    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        System.out.println(i);
        if (i == 0)
            throw new NullPointerException();
        if (i == 1)
            throw new ArithmeticException();
        if (i == 2)
            throw new FileNotFoundException();
        if (i == 3)
            throw new URISyntaxException("", "");
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        method1();

        //напишите тут ваш код
    }

    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        System.out.println(i);
        if (i == 0)
            throw new NullPointerException();
        if (i == 1)
            throw new ArithmeticException();
        if (i == 2)
            throw new FileNotFoundException();
        if (i == 3)
            throw new URISyntaxException("", "");
    }
}*/
