package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {
    private double speed;
    private double direction; // направление движения в градусах: от 0 до 360
    private double dx; // расстояние по x, которое проходит шарик за один шаг. вычисляется на основе speed и direction
    private double dy; // расстояние по y, которое проходит шарик за один шаг. вычисляется на основе speed и direction
    private boolean isFrozen;

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

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
    }

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public void move() {
    }
}
