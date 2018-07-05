package com.javarush.task.task09.task0902;

/*

И снова StackTrace

Давайте сразу перейдем к делу: напишите 5 методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его,
полученное с помощью StackTrace. Это имя — дальше, чем звезды.
Но мы разберемся, это всего-навсего методы, которые последовательно вызывают друг друга, и ничего более.

И снова StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать имя метода, вызвавшего его, полученное с помощью StackTrace.


Требования:
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать имя метода, вызвавшего его.
4. Для получения имени вызвавшего метода, используй метод getMethodName.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
       // StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElements[stackTraceElements.length - 1].getMethodName());

        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
       // StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
       //System.out.println(stackTraceElements[stackTraceElements.length - 3].getMethodName());
        //System.out.println(stackTraceElements.length);
       /* for (int i = 0; i < stackTraceElements.length; i++) {
            System.out.println(stackTraceElements[i]);
        }*/
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        //StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        /*for (StackTraceElement stackTraceElement:
             stackTraceElements) {
            System.out.println(stackTraceElement.getMethodName());
        }*/
        //System.out.println(stackTraceElements[2].getMethodName());
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        //напишите тут ваш код
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
    }

    public static String method5() {
        //напишите тут ваш код
    }
}*/
