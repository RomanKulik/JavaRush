package com.javarush.task.task13.task1313;

import java.awt.*;

/* 
Лисица — это такое животное
Вы сомневаетесь в том, что если лисичка не является грибом,
то она — животное, и на всю жизнь им останется?
Если нет, значит, такому классу очень даже подойдет интерфейс «животное», или Animal.
Так что давайте реализуем его, параллельно выполнив некоторые правки в самом классе.

Лисица — это такое животное
1. Реализуй в классе Fox интерфейс Animal.
2. Поменяй код так, чтобы в классе Fox был только один метод — getName.
3. Создавать дополнительные классы и удалять методы нельзя!


Требования:
1. Интерфейс Animal должен быть реализован в классе Fox.
2. В классе Fox должен быть реализован только один метод(getName).
3. В интерфейсе Animal должен быть объявлен метод getColor.
4. Дополнительные классы или интерфейсы создавать нельзя.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public abstract static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }
   /* public interface Animal {
        default Color getColor() {
            return null;
        }
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox";
        }
    }*/
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        Color getColor();
    }

    public static class Fox {
        public String getName() {
            return "Fox";
        }
    }
}*/
