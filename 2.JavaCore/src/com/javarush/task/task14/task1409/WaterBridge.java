package com.javarush.task.task14.task1409;

import com.javarush.task.task14.task1409.Bridge;

public class WaterBridge implements Bridge {
    private final int carsCountWater = 5;
    @Override
    public int getCarsCount() {
        return carsCountWater;
    }
}
