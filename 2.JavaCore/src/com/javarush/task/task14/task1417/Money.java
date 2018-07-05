package com.javarush.task.task14.task1417;

public abstract class Money {
    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract String getCurrencyName();
}

/*public abstract class Money {
    public Money(double amount) {
    }

    public abstract double getAmount();

    public abstract String getCurrencyName();
}*/

