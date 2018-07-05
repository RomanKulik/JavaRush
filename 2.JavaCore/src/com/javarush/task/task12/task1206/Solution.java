package com.javarush.task.task12.task1206;

/* 
Как хорошо, что в Java существует переопределение методов!
Сколько проблем это решает, какую свободу действий предоставляет!
Так что берем его на вооружение, и продолжаем усваивать на практике.
В этот раз давайте напишем два метода по имени print.
Один будет печатать целые числа, другой — строки.

Выполняем перегрузку!
Написать два метода: print(int) и print(String).


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать три метода.
3. Класс Solution должен содержать статический метод main().
4. Класс Solution должен содержать статический метод print() с параметром типа int.
5. Класс Solution должен содержать статический метод print() с параметром типа String.
*/
public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static void print(int a) {
    }

    public static void print(String s){};
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
}*/
