package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public BaseObject (double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    boolean intersects(BaseObject o) {
        double dRadius = Math.max(o.getRadius(), this.getRadius());

        // По теореме Пифагора
        double distPif = Math.sqrt(
          Math.pow(o.getX() - this.getX(), 2) +
          Math.pow(o.getY() - this.getY(), 2)
        );

        // Через hypot = sqrt((x1-x2)^2 + (y1-y2)^2)
       /* double distHypot = Math.hypot(
                o.getX() - this.getX(),
                o.getY() - this.getY()
        );*/

        return distPif <= dRadius;
    }

    abstract void draw(Canvas canvas);

    abstract void move();
}
