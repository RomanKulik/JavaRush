package com.javarush.task.task08.task0825;

/*

Модификатор запутался

Статическим может быть не каждый!
И если вдруг модификатор static попадет туда, где ему не следует быть,
может статься что угодно! В коде, который вы увидите перед собой,
щелкнув по этой задаче, так и произошло: один static оказался не в том месте.
Помогите программе скомпиллироваться, переставьте модификатор туда, где он должен быть!
Спасибо.

Модификатор запутался
Переставь один модификатор static, чтобы пример скомпилировался.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Solution должна быть переменная A.
3. В классе Solution должна быть переменная B.
4. В классе Solution должна быть переменная C.
5. В классе Solution должна быть переменная D.
6. Класс Solution должен содержать только три метода.
7. В классе должно быть 4 статика (переменные и методы).
*/

public class Solution {
    public static int A = 5;
    public static int B = 2;

    public int C = A * B;
    public static int D = B * A;

    public static void main(String[] args) {
    }

    public int getValue() {
        return D;
    }

    public int getValue2() {
        return C;
    }
}


/*
public class Solution {
    public int A = 5;
    public static int B = 2;

    public int C = A * B;
    public static int D = B * A;

    public static void main(String[] args) {
    }

    public static int getValue() {
        return D;
    }

    public int getValue2() {
        return C;
    }
}
*/

