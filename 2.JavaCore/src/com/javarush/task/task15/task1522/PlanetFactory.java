package com.javarush.task.task15.task1522;

import java.util.Scanner;

public class PlanetFactory {

    public static Planet getThePlanet(String planet){
        switch (planet) {
            case Planet.SUN:
                System.out.println("class Sun was created");
                return Sun.getInstance();
            case Planet.MOON:
                System.out.println("class Moon was created");
               return Moon.getInstance();
            case Planet.EARTH:
                System.out.println("class Earth was created");
               return Earth.getInstance();
            default:
                System.out.println("thePlanet = null");
                return null;
        }
    }

    public Planet getPlanet(String key) {
        if (key.equals(Planet.SUN))
            return Sun.getInstance();
        else if (key.equals(Planet.MOON))
            return Moon.getInstance();
        else if (key.equals(Planet.EARTH))
            return Earth.getInstance();
        else
            return null;
    }
}
