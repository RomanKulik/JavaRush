package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    static Arkanoid game;

    private int width;
    private int height;
    private boolean isGameOver;

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

    /**
     * В этом методе надо проверить - не столкнулся ли шарик с каким-нибудь из "кирпичей".
     * Для проверки столкновения используй метод intersects().
     * Если шарик все-таки попал в кирпич, то:
     * а) шарик отлетает в случайном направлении:
     * double angle = Math.random() * 360;
     * ball.setDirection(angle);
     * б) кирпич умирает - надо удалить его из списка всех кирпичей.
     */
    public void checkBricksBump() {
        for (Brick b : bricks) {
            if (this.ball.intersects(b)) {
                bricks.remove(b);
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                break;
            }
        }
    }

    /**
     * В этом методе надо проверить - не ударился ли шарик о подставку.
     * Для проверки столкновения используй метод intersects().
     * Если шарик все-таки ударился о подставку, то:
     * шарик отлетает в случайным направлении вверх:
     * double angle = 90 + 20 * (Math.random() - 0.5);
     * ball.setDirection(angle);
     */
    public void checkStandBump() {
        if (ball.intersects(stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    /**
     * Если координата y шарика больше чем высота поля игры (height),
     * значит шарик улетел вниз за границу экрана.
     * В этом случае надо переменную isGameOver установить в true.
     */
    public void checkEndGame(){
        if (ball.y > height)
            isGameOver = true;
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
