package com.javarush.task.task09.task0920;

/* 

Обратный отсчёт

На контрольной работе в секретном центре JavaRush студентам дали задание:
написать обратный отсчёт от 10 до 0, чтобы определить,
сколько времени осталось до конца этой самой контрольной работы.
Правда, классно?
Для задержки нужно использовать Thread.sleep(100), а вызов sleep обернуть в try..catch.
Время пошло!
Обратный отсчёт
Написать в цикле обратный отсчёт от 10 до 0. Для задержки использовать Thread.sleep(100);
Обернуть вызов sleep в try..catch.


Требования:
1. Программа должна выводить отсчет от 10 до 0.
2. Программа должна выводить на экран новое число каждые 100 миллисекунд.
3. Программа должна использовать метод "Thread.sleep(100);".
4. Метод main должен содержать блок try..catch.
5. Метод main не должен кидать исключений.
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            //напишите тут ваш код
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);

            //напишите тут ваш код
        }
    }
}*/
