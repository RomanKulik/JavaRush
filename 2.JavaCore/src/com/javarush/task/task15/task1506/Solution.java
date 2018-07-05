package com.javarush.task.task15.task1506;

/* 
Что-то лишнее
И снова наша программа полна ненужных строк кода.
Исправим эту оплошность, и удалим реализации всех лишних методов,
чтобы программа выводила то, и только то, что требует условие.
Кстати, привыкайте к этому, страсть "джунов" делать лишнее изрядно раздражает "старших".

Что-то лишнее
1. Программа должна выводить следующее:
Это double
Это Object
Это double
Это Integer
Это double

2. Удали реализации всех лишних методов


Требования:
1. В классе Solution должен остаться метод print с одним параметром типа Integer.
2. В классе Solution должен остаться метод print с одним параметром типа Object.
3. В классе Solution должен остаться метод print с одним параметром типа double.
4. Вывод на экран должен соответствовать условию.
*/
public class Solution {
    public static void main(String[] args) {
        print((short) 1); // double
        print((Number) 1); // Object
        print(1); // double
        print((Integer) 1); // Integer
        print((int) 1); // double
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

    /*public static void print(int i) {
        System.out.println("Это Integer");
    }*/

    /*public static void print(Short i) {
        System.out.println("Это Object");
    }*/

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    /*public static void print(Number i) {
        System.out.println("Это Number");
    }*/

  public static void print(double i) {
    System.out.println("Это double");
}

    /*public static void print(Double i) {
        System.out.println("Это double");
    }*/

    /*public static void print(float i) {
        System.out.println("Это Double");
    }*/
}
/*public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

    public static void print(int i) {
        System.out.println("Это Integer");
    }

    public static void print(Short i) {
        System.out.println("Это Object");
    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Double i) {
        System.out.println("Это double");
    }

    public static void print(float i) {
        System.out.println("Это Double");
    }
}*/
