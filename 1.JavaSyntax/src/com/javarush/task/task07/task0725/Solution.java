package com.javarush.task.task07.task0725;

/*

Переставь один модификатор static

Статическим может быть не каждый! И если вдруг модификатор static попадет туда,
где ему не следует быть, может статься что угодно! В коде, который вы увидите перед собой,
щелкнув по этой задаче, так и произошло: один static оказался не в том месте.
Помогите программе скомпиллироваться, переставьте модификатор туда, где он должен быть!
Спасибо.

Переставь один модификатор static
Переставь один модификатор static, чтобы пример скомпилировался.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе должна быть переменная A.
3. В классе должна быть переменная B.
4. В классе должна быть переменная C.
5. В классе должен быть метод main.
6. В классе должен быть метод getValue.
7. В классе должно быть 4 модификатора static (переменные и методы).
*/

public class Solution {
    public static final  int A = 5;
    public static final  int B = 2;
    public static final  int C = A * B;

    public static void main(String[] args) {

    }

    public int getValue() {
        return C;
    }
}


/*
public class Solution {
    public final int A = 5;
    public final static int B = 2;
    public final static int C = A * B;

    public static void main(String[] args) {
    }

    public static int getValue() {
        return C;
    }
}
*/
