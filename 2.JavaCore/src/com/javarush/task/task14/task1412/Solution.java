package com.javarush.task.task14.task1412;

import java.util.ArrayList;
import java.util.List;


/* 
Реализовать метод printMainInfo
Напишите реализацию метода printMainInfo, чтобы:
* Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
* Если в метод передают объект типа Movable, у этого объекта вызывался метод move.

Реализовать метод printMainInfo
1. Напиши реализацию метода printMainInfo, чтобы:
1.1. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
1.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.


Требования:
1. Класс Solution должен содержать реализацию метода printMainInfo
с одним параметром типа Object.
2. Метод printMainInfo должен быть статическим.
3. Метод printMainInfo должен иметь самый широкий уровень доступа(public).
4. Метод printMainInfo должен вызывать у переданного ему в качестве параметра объекта
метод draw, если этот объект реализует интерфейс Drawable.
5. Метод printMainInfo должен вызывать у переданного ему в качестве параметра
объекта метод move, если этот объект реализует интерфейс Movable.
*/
public class Solution {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        //напишите тут ваш код
        if (object instanceof Movable) {
            ((Movable)object).move();
        } else if (object instanceof Drawable) {
            ((Drawable)object).draw();
        }

       /* Class < ? >[] ii = object.getClass().getInterfaces();
        for(int i = 0; i < ii.length; ++i) {
            if (ii[i] == Drawable.class) {
                Drawable o = (Drawable) object;
                o.draw();
            } else if (ii[i] == Movable.class) {
                Movable o = (Movable) object;
                o.move();
            }
        }*/
    }

    static interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("can be drawn");
        }

        public void move() {
            System.out.println("can be moved");
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("can be drawn");
        }

        public void move() {
            System.out.println("can be moved");
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        //напишите тут ваш код
    }

    static interface Movable {

        void move();
    }

    static class Circle implements Movable {

        public void draw() {
            System.out.println("can be drawn");
        }

        public void move() {
            System.out.println("can be moved");
        }

    }

    static interface Drawable {
        void draw();
    }

    static class Rectangle implements Drawable {
        public void draw() {
            System.out.println("can be drawn");
        }

        public void move() {
            System.out.println("can be moved");
        }
    }
}*/
