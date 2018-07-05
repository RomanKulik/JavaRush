package com.javarush.task.task09.task0914;

/*

Группа перехвата исключений

Есть 3 исключения, последовательно унаследованные от
Exception (Exception1 extends Exception, Exception2 extends Exception1 и Exception3 extends Exception2).
В программе вы найдете метод public static void method1() throws Exception1, Exception2, Exception3.
Задача: написать ловца catch, который перехватит все три Exception1, Exception2 и Exception3.

Группа перехвата исключений
1. Есть три исключения последовательно унаследованные от Exception:
2. class Exception1 extends Exception
3. class Exception2 extends Exception1
4. class Exception3 extends Exception2
5. Есть метод, который описан так:
public static void method1() throws Exception1, Exception2, Exception3
6. Напиши catch, который перехватит все три Exception1, Exception2 и Exception3


Требования:
1. Метод main должен вызывать метод method1.
2. Метод main должен перехватывать исключение Exception1.
3. Метод main должен перехватывать исключение Exception2.
4. Метод main должен перехватывать исключение Exception3.
5. Метод method1 не изменять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try {
            method1();
        /*} catch (Exception3 exception3) {
            System.out.println(exception3);
        } catch (Exception2 exception2) {
            System.out.println(exception2);*/
        } catch (Exception1 exception1) {
            System.out.println(exception1);
        }

        //напишите тут ваш код

    }

    public static void method1() throws Exception1, Exception2, Exception3 {
        int i = (int) (Math.random() * 3);
        System.out.println(i);
        if (i == 0)
            throw new Exception1();
        if (i == 1)
            throw new Exception2();
        if (i == 2)
            throw new Exception3();
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

            method1();

        //напишите тут ваш код

    }

    public static void method1() throws Exception1, Exception2, Exception3 {
        int i = (int) (Math.random() * 3);
        System.out.println(i);
        if (i == 0)
            throw new Exception1();
        if (i == 1)
            throw new Exception2();
        if (i == 2)
            throw new Exception3();
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}*/
