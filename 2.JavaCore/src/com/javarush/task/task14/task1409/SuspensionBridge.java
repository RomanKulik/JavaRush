package com.javarush.task.task14.task1409;

import com.javarush.task.task14.task1409.Bridge;

public class SuspensionBridge implements Bridge {
    private final int carsCountBridge = 10;

    @Override
    public int getCarsCount() {
        return carsCountBridge;
    }
}
