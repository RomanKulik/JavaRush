package com.javarush.task.task15.task1517;

/* 
Статики и исключения
Бросаемся исключениями!
В статическом блоке выбросьте Exception,
чтобы в результате класс не загрузился,
и вы увидели сообщение об ошибке вместо значения переменной.

Статики и исключения
В статическом блоке выбросьте Exception
В результате класс не загрузится,
и вы увидите сообщение об ошибке вместо значения переменной B

Exception in thread "main" java.lang.ExceptionInInitializerError
at java.lang.Class.forName0(Native Method)
at java.lang.Class.forName(Class.java:186)
at com.intellij.rt.execution.application.AppMain.main(AppMain.java:113)
Caused by: java.lang.RuntimeException:
at com.javarush.test.level15.lesson09.task04.Solution.clinit(Solution.java:22)

Hint: Нужно погуглить причину, если получилось следующее:
java: initializer must be able to complete normally
java: unreachable statement


Требования:
1. В классе Solution в статическом блоке должно возникать исключение(Exception).
2. Программа не должна ничего выводить на экран
(кроме автоматического сообщения о возникшем исключении).
3. Программа не должна считывать данные с клавиатуры.
4. Класс Solution должен быть public.
*/
public class Solution {
    public static int A = 0;

    static {
        int a = 6/A;
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
/*public class Solution {
    public static int A = 0;

    static {

    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}*/
