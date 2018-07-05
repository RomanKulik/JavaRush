package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {

    /* UkrainianHen(int n) {
        getDescription();
    }*/

    @Override
    String getDescription() {
        return super.getDescription()
                + " Моя страна - " + Country.UKRAINE
                + ". Я несу " + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }
}
