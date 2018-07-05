package com.javarush.task.task13.task1328;

import java.util.Random;

public abstract class AbstractRobot implements Attackable, Defensable {
    private static int hitCount;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

   @Override
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;
        hitCount = 1 + (int)(Math.random() * 4);
       //System.out.println(hitCount);

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            //hitCount = 0;
            attackedBodyPart = BodyPart.CHEST;
        }
        return attackedBodyPart;
    }

    @Override
    public BodyPart defense() {
        BodyPart defencedBodyPart = null;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 4) {
            hitCount = 0;
            defencedBodyPart = BodyPart.CHEST;
        }
        return defencedBodyPart;
    }
}
/*public class AbstractRobot {
}*/
