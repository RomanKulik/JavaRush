package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее
Не всякая перегрузка метода приносит пользу.
Вот так и в этой программе.
Давайте посмотрим на её код, и подумаем,
какая из реализаций метода print будет вызвана.
Затем удалите все лишние реализации этого метода — и дело с концом. \

ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.


Требования:
1. В классе Solution кроме метода main
должен остаться только один метод print(с правильным параметром!).
2. Метод print должен быть публичным.
3. Метод print должен быть статическим.
4. Программа должна выводить на экран строку "Я буду Java прогером!".
*/
public class Solution {
    public static void main(String[] args) {
        print(1);
    }

   /* public static void print(byte b) {
        System.out.println("byte");
        System.out.println("Я буду Java прогером!");
    }*/

   /* public static void print(double d) {
        System.out.println("double");
        System.out.println("Я буду Java прогером!");
    }*/

    public static void print(long l) {
        //System.out.println("long");
        System.out.println("Я буду Java прогером!");
    }

   /* public static void print(float f) {
        System.out.println("float");
        System.out.println("Я буду Java прогером!");
    }*/

  /*  public static void print(char c) {
        System.out.println("char");
        System.out.println("Я буду Java прогером!");
    }*/
}
/*public class Solution {
    public static void main(String[] args) {
        print(1);
    }

    public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }
}*/
