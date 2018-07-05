package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {

    /* RussianHen(int n) {
        getDescription();
    }*/

    @Override
    String getDescription() {
        return super.getDescription()
                + " Моя страна - " + Country.RUSSIA
                + ". Я несу " + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return 80;
    }
}
