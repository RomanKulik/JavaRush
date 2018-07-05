package com.javarush.task.task14.task1421;

public class Singleton_Idea {
    private static Singleton_Idea ourInstance = new Singleton_Idea();

    public static Singleton_Idea getInstance() {
        return ourInstance;
    }

    private Singleton_Idea() {
    }
}
