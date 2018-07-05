package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            president = new OurPresident();
        }
    }

    private OurPresident() {
        System.out.println("Constr");
    }

    public static OurPresident getOurPresident() {
        System.out.println("GetPres");
        return president;
    }
}

/*
public class OurPresident {
    private static OurPresident president;

    private OurPresident() {

    }

    public static OurPresident getOurPresident() {
        return president;
    }
}*/
