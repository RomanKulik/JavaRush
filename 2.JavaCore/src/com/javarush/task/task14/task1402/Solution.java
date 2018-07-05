package com.javarush.task.task14.task1402;

/* 
Bingo-2!
Урок английского на JavaRush: в знаменитом мультике кота совершенно не зря зовут Томом.
Оказывается, Tomcat на языке Шекспира — это любой кот мужского пола.
Очевидно, Tomcat является ещё и «просто» котом и может двигаться.
Исправьте программу так, чтобы в переменной cat хранился объект,
который одновременно является и Movable, и Cat, и Tomcat.

Bingo-2!
Исправь строчку 'Cat cat = new Cat();' так, чтобы программа вывела "Bingo!".


Требования:
1. Класс Cat должен реализовывать интерфейс Movable.
2. Класс Cat должен быть родителем(родительским классом) класса TomCat.
3. В переменной cat должен храниться объект который будет одновременно являться и Movable, и Cat, и Tomcat.
4. Программа должна выводить на экран: "Bingo!".
*/
public class Solution {
    public static void main(String[] args) {
        Cat cat = new TomCat();

        boolean isCat = cat instanceof Cat;
        boolean isMovable = cat instanceof Movable;
        boolean isTom = cat instanceof TomCat;

        if (isCat && isMovable && isTom) System.out.println("Bingo!");
    }

    interface Movable {
    }

    static class Cat implements Movable {
    }

    static class TomCat extends Cat {

    }
}
/*public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat();

        boolean isCat = cat instanceof Cat;
        boolean isMovable = cat instanceof Movable;
        boolean isTom = cat instanceof TomCat;

        if (isCat && isMovable && isTom) System.out.println("Bingo!");
    }

    interface Movable {
    }

    static class Cat implements Movable {
    }

    static class TomCat extends Cat {

    }
}*/
