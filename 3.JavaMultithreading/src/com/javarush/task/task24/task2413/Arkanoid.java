package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    static Arkanoid game;

    private int width;
    private int height;

    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return this.ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return this.stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return this.bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }


    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void move() {
        this.ball.move();
        this.stand.move();
    }

    void draw(Canvas canvas) {
        this.stand.draw(canvas);
        this.ball.draw(canvas);

        for (Brick b : bricks) {
            b.draw(canvas);
        }
    }

    public void run() {
    }

    public static void main(String[] args) {

    }
}
