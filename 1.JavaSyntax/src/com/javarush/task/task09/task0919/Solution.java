package com.javarush.task.task09.task0919;

/* 

Деление на ноль

Возможно, вам давно этого хотелось, но было боязно?
Барабанная дробь…Сегодня мы займемся делением на нуль!
На самом деле, можно, если осторожно.
Создайте метод public static void divisionByZero,
в котором поделите любое число на ноль и выведи на экран результат деления.
Оберните вызов метода в try..catch и выведите стек-трейс исключения.

Деление на ноль
Создай метод public static void divisionByZero, в котором подели любое число на ноль и выведи на экран результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя метод exception.printStackTrace()


Требования:
1. В классе должен быть метод public static void divisionByZero().
2. Метод divisionByZero должен содержать операцию деления любого числа на ноль.
3. Метод divisionByZero должен вызывать System.out.println или System.out.print.
4. Метод main должен содержать блок try..catch.
5. Метод main должен отлавливать любые исключения метода divisionByZero.
6. Программа должна выводить стек-трейс пойманого исключения.
*/

public class Solution {

    public static void main(String[] args) {

        try {
            divisionByZero();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static void divisionByZero() {
        System.out.println(3 / 0);
    }
}

/*public class Solution {

    public static void main(String[] args) {
        divisionByZero();
    }
}*/
