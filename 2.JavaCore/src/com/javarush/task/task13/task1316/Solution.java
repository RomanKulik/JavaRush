package com.javarush.task.task13.task1316;

/* 
Некорректные строки
Есть интерфейс Button, полный некорректных строк.
Вы, наверное, уже догадались, что вам нужно их удалить оттуда,
и при этом не выйти за рамки установленных требований.
Желаем удачи на этом поприще!

Некорректные строки
Удали все некорректные строки в интерфейсе Button.


Требования:
1. Интерфейс SimpleObject должен быть объявлен внутри класса Solution.
2. Интерфейс Button должен быть объявлен внутри класса Solution.
3. Метод main менять нельзя.
4. В интерфейсе Button должно остаться объявление константы NAME.
5. В интерфейсе Button должно остаться корректное объявление метода onPress.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";

        String onPress(Object o);


       /* public void onPress();

        protected void onPress();

        void onPress();

        private void onPress();

        protected String onPress(Object o);

        private String onPress(Object o);*/

    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        final String NAME = "Submit";

        public void onPress();

        protected void onPress();

        void onPress();

        private void onPress();

        protected String onPress(Object o);

        String onPress(Object o);

        private String onPress(Object o);

    }
}*/
