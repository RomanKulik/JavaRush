package com.javarush.task.task24.task2413;


/**
 * Что мы будем делать с Canvas?
 * Мы будем рисовать на нем (в его матрице).
 * Поэтому нам понадобятся два метода:
 * void setPoint(double x, double y, char c)
 * void drawMatrix(double x, double y, int[][] matrix, char c)
 */
public class Canvas {
    private int height;
    private int width;
    private char[][] matrix;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getMatrix() {
        return this.matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;

        this.matrix = new char[this.height + 2][this.width + 2];
    }

    /**
     * Первый метод - setPoint будет "ставить точку в координатах x,y цветом c".
     * В методе надо:
     * а) округлить x и y до целых чисел, используя метод Math.round()
     * б) занести в matrix[y][x] значение с
     * в) ничего не делать, если x < 0 или y < 0 или
     * y >= matrix.length или x >= matrix[0].length
     */
    void setPoint(double x, double y, char c) {
        int rx = (int) Math.round(x);
        int ry = (int) Math.round(y);

        if (!(rx < 0 || ry < 0 ||
                ry > this.matrix.length ||
                rx >= this.matrix[0].length)) {
            this.matrix[ry][rx] = c;
        }
    }

    /**
     * Второй метод - drawMatrix копирует переданную ему картинку (матрицу)
     * в матрицу Canvas.
     * И не просто копирует, а начиная с координат x, y
     * В методе надо:
     * а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
     * б) если значение ячейки элемента [i][j] полученной матрицы не равно 0,
     * то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
     * setPoint(x+j, y+i, c)
     */
    void drawMatrix(double x, double y, int[][] matrix, char c) {
        int rx = (int) Math.round(x);
        int ry = (int) Math.round(y);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    /**
     * Еще Canvas понадобится два метода, напиши их.
     * а) метод clear()
     * Этот метод будет очищать матрицу, чтобы на ней снова можно было рисовать.
     * Можешь просто заново инициализировать matrix пустым массивом правильной размерности.
     */
    void clear() {
        this.matrix = new char[this.height+2][this.width+2];
    }

    /**
     * б) метод print()
     * Этот метод рисует матрицу на экран.
     * Тут уже ты должен сам разобраться: вывести набор символов не так уж и сложно.
     */
    void print() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                System.out.print(this.matrix[i][j]);
            }
            System.out.println();
        }
    }
}
