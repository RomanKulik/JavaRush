package com.javarush.task.task20.task2026;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-прямоугольники

Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников
(в соответствии с заданием) найденное в полученном массиве.
*/
public class Solution {
    private static List<Rectangle> rectangleList = new ArrayList<>();

    public static class Coordinate {
        int X;
        int Y;

        public Coordinate() {
        }

        public Coordinate(int x, int y) {
            X = x;
            Y = y;
        }
    }

    public static class Rectangle {
        private Coordinate leftTop;
        private Coordinate rightTop;
        private Coordinate leftDown;
        private Coordinate rightDown;

        public Rectangle() {
        }

        public Rectangle(Coordinate leftTop,
                         Coordinate rightTop,
                         Coordinate leftDown,
                         Coordinate rightDown) {
            this.leftTop = leftTop;
            this.rightTop = rightTop;
            this.leftDown = leftDown;
            this.rightDown = rightDown;
        }

        public Coordinate getLeftTop() {
            return leftTop;
        }

        public void setLeftTop(Coordinate leftTop) {
            this.leftTop = leftTop;
        }

        public Coordinate getRightTop() {
            return rightTop;
        }

        public void setRightTop(Coordinate rightTop) {
            this.rightTop = rightTop;
        }

        public Coordinate getLeftDown() {
            return leftDown;
        }

        public void setLeftDown(Coordinate leftDown) {
            this.leftDown = leftDown;
        }

        public Coordinate getRightDown() {
            return rightDown;
        }

        public void setRightDown(Coordinate rightDown) {
            this.rightDown = rightDown;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        int count1 = getRectangleCount(a3);
        /*int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");*/
    }

    public static int getRectangleCount(byte[][] a) throws IOException, ClassNotFoundException {
        byte[][] copy = a.clone();
        byte[][] tmp = a;
        int counter = 0;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);

        ByteArrayInputStream bais = new ByteInputStream();
        ObjectInputStream ois = new ObjectInputStream(bais);

        copy = (byte[][])ois.readObject();

        System.out.println("a");
        sout1(a);
        System.out.println("tmp");
        sout1(tmp);
        System.out.println("copy");
        sout1(copy);
        System.out.println();

        tmp[1][1] = 3;
        System.out.println("a[1][1] = 3");
        System.out.println("a");
        sout1(a);
        System.out.println("tmp");
        sout1(tmp);
        System.out.println("copy");
        sout1(copy);
        System.out.println();

        foo(a);
        System.out.println("foo(a)");
        System.out.println("a");
        sout1(a);
        System.out.println("tmp");
        sout1(tmp);
        System.out.println("copy");
        sout1(copy);


        return counter;
    }

    static void foo(byte[][] arr) {
        arr[0][0] = 9;
    }

    static void sout1(byte[][] arrr) {
        for (int i = 0; i < arrr.length; i++) {
            for (int j = 0; j < arrr[i].length; j++) {
                System.out.print(arrr[i][j] + ", ");
            }
            System.out.println();
        }
    }


}

/*
package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники

Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников
(в соответствии с заданием) найденное в полученном массиве.
*/
/*
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        return 0;
    }
}

 */