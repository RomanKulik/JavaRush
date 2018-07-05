package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private static Sun instance;

    private Sun(){ }

    private static class InstanceHolder {
        private static Sun instance = new Sun();
    }

    public static Sun getInstance() {
        instance = InstanceHolder.instance;
        return instance;
    }
}