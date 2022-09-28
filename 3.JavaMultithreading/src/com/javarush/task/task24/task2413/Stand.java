package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {
    private double speed; // скорость шарика
    // направление движения по оси x:
    // 1 - вправо, -1 - влево, 0 - начальное значение, стоим на месте
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    public void draw(Canvas canvas) {
    }

    /**
     * Движение доски осуществляется горизонтально, поэтому мы меняем только координату х.
     * Подумай, как координата х зависит от направления (direction) и скорости (speed). Реализуй зависимость.
     * б) draw - см. draw в BaseObject
     */
    @Override
    public void move() {
        this.x += speed * direction;
    }

    void moveLeft() {
        direction = -1;
    }

    void moveRight() {
        direction = 1;
    }
}
