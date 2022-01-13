package com.javarush.task.task22.task2206;

        import java.util.Date;

/*
Форматирование даты
Форматирование даты: "td:tm:ty tH:tM:tS" = "td:tm:ty tT"; "tD - 01/14/22"
Исправить метод getFormattedString так,
чтобы он возвращал строку с параметрами для форматирования.

Должен быть вывод аналогичный следующему:
05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)


Requirements:
1. Метод getFormattedString должен быть публичным.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать
строку с параметрами для форматирования согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        //return "%td:%tm:%ty %tH:%tM:%tS";
        return "%td:%tm:%ty %tT"; //%tD - 01/14/22
    }
}

/*
package com.javarush.task.task22.task2206;

import java.util.Date;

/*
Форматирование даты
Форматирование даты
Исправить метод getFormattedString так,
чтобы он возвращал строку с параметрами для форматирования.

Должен быть вывод аналогичный следующему:
05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)


Requirements:
1. Метод getFormattedString должен быть публичным.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать
строку с параметрами для форматирования согласно условию задачи.


public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        return "";
    }
}

 */