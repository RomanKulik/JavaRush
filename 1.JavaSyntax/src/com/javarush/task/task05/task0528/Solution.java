package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде «21 02 2014«.


Требования:
1. Дата должна содержать день, месяц и год, разделенные пробелом.
2. День должен соответствовать текущему.
3. Месяц должен соответствовать текущему.
4. Год должен соответствовать текущему.
5. Вся дата должна быть выведена в одной строке.
*/

/*public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
    }
}*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date dateNow = new Date();
        //SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        //System.out.println("Текущая дата " + formatForDateNow.format(dateNow));*/
        SimpleDateFormat date = new SimpleDateFormat("dd MM yyy");
        System.out.println(date.format(dateNow));
    }
}