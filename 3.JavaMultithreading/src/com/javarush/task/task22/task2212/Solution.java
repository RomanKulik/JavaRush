package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
Проверка номера телефона RegEx
Метод checkTelNumber должен проверять,
является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки,
то он содержит 10 цифр
3) может содержать 1 пару скобок '(' и ')'
4) скобки (если они есть) внутри содержат четко 3 цифры
5) номер может содержать только цифры, '+', '(' и ')'
6) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
(050)1234567 - true
0(501)234567 - true
+38)050(1234567 - false
+38(050)123-45-67 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Requirements:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера
телефона переданного ему в качестве параметра.
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[()]?){12}$") ||
                telNumber.matches("^([()]?\\d){10}$")) &&
                telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");

      /*  if (telNumber != null && (
                telNumber.matches("^\\+\\d{12}$") ||
                telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}$") ||
                telNumber.matches("^0?\\(\\d{3}\\)\\d{6,7}$")))
            return true;
        return false;*/
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567")); // true
        System.out.println(checkTelNumber("+38(050)1234567")); // true
        System.out.println(checkTelNumber("(050)1234567")); // true
        System.out.println(checkTelNumber("0(501)234567")); // true
        System.out.println(checkTelNumber("+38)050(1234567")); // false
        System.out.println(checkTelNumber("+38(050)123-45-67")); // false
        System.out.println(checkTelNumber("050ххх4567")); // false
        System.out.println(checkTelNumber("050123456")); // false
        System.out.println(checkTelNumber("(0)501234567")); // false
    }
}

/*
package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
Проверка номера телефона
Метод checkTelNumber должен проверять,
является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки,
то он содержит 10 цифр
3) может содержать 1 пару скобок '(' и ')'
4) скобки (если они есть) внутри содержат четко 3 цифры
5) номер может содержать только цифры, '+', '(' и ')'
6) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
(050)1234567 - true
0(501)234567 - true
+38)050(1234567 - false
+38(050)123-45-67 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Requirements:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера
телефона переданного ему в качестве параметра.


public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        return false;
    }

    public static void main(String[] args) {

    }
}

 */