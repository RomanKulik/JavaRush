package com.javarush.task.task15.task1516;

import java.lang.reflect.*;

/* 
Значения по умолчанию
В этой задаче вам предстоит создать 7 полей public для класса.
Убедитесь, что они инициализируются дефолтными значениями
(intVar типа int, doubleVar типа double, DoubleVar типа Double,
booleanVar типа boolean, ObjectVar типа Object,
ExceptionVar типа Exception и StringVar типа String).
В методе main выведите их значения в заданном порядке.

Значения по умолчанию
1. Создать 7 public полей класса.
Убедитесь, что они инициализируются дефолтными значениями.
intVar типа int
doubleVar типа double
DoubleVar типа Double
booleanVar типа boolean
ObjectVar типа Object
ExceptionVar типа Exception
StringVar типа String
2. В методе main вывести их значения в заданном порядке.


Требования:
1. В классе Solution должно быть объявлено поле intVar типа int.
2. В классе Solution должно быть объявлено поле doubleVar типа double.
3. В классе Solution должно быть объявлено поле DoubleVar типа Double.
4. В классе Solution должно быть объявлено поле booleanVar типа boolean.
5. В классе Solution должно быть объявлено поле ObjectVar типа Object.
6. В классе Solution должно быть объявлено поле ExceptionVar типа Exception.
7. В классе Solution должно быть объявлено поле StringVar типа String.
8. Метод main должен выводить значения полей на экран
(каждое с новой строки или через пробел) в заданном порядке.
Инициализировать переменные не нужно.
*/
public class Solution {
   /* public static int intVar;
    public static double doubleVar;
    public static Double DoubleVar;
    public static boolean booleanVar;
    public static Object ObjectVar;
    public static Exception ExceptionVar;
    public static String StringVar;*/

    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public static void main(String[] args) throws IllegalAccessException {
        Solution s = new Solution();

        for(Field f : Solution.class.getDeclaredFields())
            System.out.println(f.get(s));

        System.out.println(s.intVar);
        System.out.println(s.doubleVar);
        System.out.println(s.DoubleVar);
        System.out.println(s.booleanVar);
        System.out.println(s.ObjectVar);
        System.out.println(s.ExceptionVar);
        System.out.println(s.StringVar);
    }
}
/*public class Solution {
    public static void main(String[] args) {
    }
}*/
