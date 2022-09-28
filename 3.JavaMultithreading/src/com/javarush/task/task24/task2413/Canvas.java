package com.javarush.task.task24.task2413;

public class Canvas {
    private int height;
    private int width;
    private char[][] matrix;

    public int getHeight(){
        return this.height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public char[][] getMatrix(){
        return this.matrix;
    }

    public void setMatrix(char[][] matrix){
        this.matrix = matrix;
    }

    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;

        this.matrix = new char[this.height + 2][this.width + 2];
    }
}
