package com.javarush.task.task12.task1210;

/* 
Мы снова на границе влияния планеты Линейный Хаос, где живут Упорядоченные Изоморфы.
Все, кто хотят получить визу, решают задачки на сортировку и упорядочивание.
В этот раз они очень добры, задача — весьма проста: вам нужно создать 3 метода,
которые возвращают максимум из двух чисел long, double или int.

Три метода и максимум
Написать public static методы: int max(int, int), long max(long, long), double max(double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать четыре метода.
3. Класс Solution должен содержать статический метод int max(int, int).
4. Метод int max(int, int) должен возвращать максимальное из двух чисел типа int.
5. Класс Solution должен содержать статический метод long max(long, long).
6. Метод long max(long, long) должен возвращать максимальное из двух чисел типа long.
7. Класс Solution должен содержать статический метод double max(double, double).
8. Метод double max(double, double) должен возвращать максимальное из двух чисел типа double.
*/
public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int i, int j) { return Math.max(i, j); }
    public static long max(long l, long ll) { return Math.max(l, ll); }
    public static double max(double v, double vv) { return Math.max(v, vv); }
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
}*/
