package com.javarush.task.task06.task0609;

/* 

Расстояние между двумя точками

Вы в курсе, что между любыми две точки на плоскости можно провести прямую?
Наверное, в курсе, а если нет — Евклид и его «Начала» к вашим услугам.
Хотя лучше принять на веру этот постулат и написать статический метод double getDistance(x1, y1, x2, y2).
Он должен вычислять расстояние между точками.

Расстояние между двумя точками
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра.


Требования:
1. Метод getDistance должен возвращать double.
2. Метод getDistance должен быть статическим.
3. Метод getDistance должен быть public.
4. Метод getDistance должен возвращать расстояние между точками.
5. Метод getDistance должен использовать метод double Math.sqrt(double a).
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        int x = x2 * x2 - 2 * x2 * x1 + x1 * x1;
        int y = y2 * y2 - 2 * y2 * y1 + y1 * y1;
        //System.out.println(Math.sqrt(x + y));
        return Math.sqrt(x + y);
    }

    public static void main(String[] args) {
       /* getDistance(-2, 4, 8, 1);   // (8+2)^2+(1-4)^2 = 100+9 -> 10....
        System.out.println();*/
    }
}
