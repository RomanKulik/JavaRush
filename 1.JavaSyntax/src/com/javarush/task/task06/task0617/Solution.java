package com.javarush.task.task06.task0617;

/*

Блокнот для новых идей

Крутые идеи нужно записывать, они забываются очень быстро.
Для этого в классе Solution создадим статический класс Idea,
а в нем — метод public String getDescription(),
который будет возвращать любой непустой текст.
Затем создадим статический метод public void printIdea(Idea idea) —
он выведет описание нашей идеи на экран.

Блокнот для новых идей
1. В классе Solution создать public static класс Idea
2. В классе Idea создать метод public String getDescription(),
который будет возвращать любой непустой текст
3. В классе Solution создай статический метод public void printIdea(Idea idea),
который будет выводить на экран описание идеи — это то,
что возвращает метод getDescription


Требования:
1. В классе Solution создать public статический класс Idea.
2. В классе Idea создать метод public String getDescription().
3. Метод getDescription должен возвращать любой непустой текст.
4. В классе Solution создайте статический метод public void printIdea(Idea idea).
5. Метод printIdea должен выводить описание идеи на экран.
*/

public class Solution {
    public static void main(String[] args) {

        printIdea(new Idea());
    }

    //напишите тут ваш код
    public static class Idea {
        public String getDescription() {
            return "My idea";
        }
    }

    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription());
    }
}

/*
public class Solution {
    public static void main(String[] args) {

        printIdea(new Idea());
    }

    //напишите тут ваш код
}*/
