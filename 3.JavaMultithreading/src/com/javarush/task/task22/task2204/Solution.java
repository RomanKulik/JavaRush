package com.javarush.task.task22.task2204;

/* 
Форматирование строки
Форматирование строки: String.format %n (кроссплатф) = \n, %.2f=2,86, %.2e=3,33e+00
Исправить метод getFormattedString так,
чтобы он возвращал строку с параметрами для форматирования.
Для перевода каретки не используй \n.

Должен быть вывод:
20 / 7 = 2,86
Exp = 3,33e+00


Requirements:
1. Для перевода строки не должно быть использовано выражение \n.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать строку
с параметрами для форматирования согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), 20.0 / 7.0, 10.0 / 3.0));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = %.2f%nExp = %.2e";
        /*String line = System.lineSeparator();
        return "20 / 7 = %.2f" + line + "Exp = %.2e";*/
    }
}

/*
package com.javarush.task.task22.task2204;

/*
Форматирование строки
Форматирование строки
Исправить метод getFormattedString так,
чтобы он возвращал строку с параметрами для форматирования.
Для перевода каретки не используй \n.

Должен быть вывод:
20 / 7 = 2,86
Exp = 3,33e+00


Requirements:
1. Для перевода строки не должно быть использовано выражение \n.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать строку
с параметрами для форматирования согласно условию задачи.


public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), 20.0 / 7.0, 10.0 / 3.0));
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = % %Exp = %";
    }
}

 */