package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {
    private double speed;
    private double direction; // направление движения в градусах: от 0 до 360
    // расстояние по x, которое проходит шарик за один шаг. вычисляется на основе speed и direction
    private double dx;
    // расстояние по y, которое проходит шарик за один шаг. вычисляется на основе speed и direction
    private double dy;
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

    /**
     * Во-первых нужен метод setDirection,
     * который не только устанавливает значение переменной direction,
     * но и вычисляет новые значения переменных dx и dy.
     *
     * @param direction
     */
    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
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

    /**
     * Во-вторых надо реализовать метод draw(Canvas canvas):
     * на объекте canvas необходимо вызвать метод setPoint с параметрами (x, y, 'O')
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'O');
    }

    /**
     * а) x должен увеличиваться на dx каждый ход
     * б) y должен увеличиваться на dy каждый ход
     * если шарик "заморожен", то x и y меняться не должны
     */
    @Override
    public void move() {
        if (!isFrozen) {
            this.x += this.getDx();
            this.y += this.getDy();
        }
    }

    /**
     * В-третьих надо создать и реализовать метод void start():
     * именно его вызов "размораживает" шарик.
     * Что для этого надо сделать - это ты уже сам реши.
     */
    void start() {
        this.isFrozen = false;
    }

    /**
     * Во-вторых шарик может удариться о стенку.
     * При этом он должен от нее отскочить.
     * @param minx
     * @param maxx
     * @param miny
     * @param maxy
     */
    void checkRebound(int minx, int maxx, int miny, int maxy){

    }
}
