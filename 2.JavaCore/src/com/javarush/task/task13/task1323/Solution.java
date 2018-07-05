package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
Капитан Бобров представляет: ещё одна замечательная программа,
которую предстоит создать ученикам секретного центра JavaRush!
В этот раз вам нужно создать интерфейс Updatable в классе Screen.

Интерфейс Updatable в классе Screen
Реализовать интерфейс Updatable в классе Screen.


Требования:
1. Интерфейс Updatable должен наследовать(extends) интерфейс Selectable.
2. Класс Screen должен реализовывать(implements) интерфейс Updatable.
3. В классе Screen должен быть реализован метод onSelect интерфейса Selectable.
4. В классе Screen должен быть реализован метод refresh интерфейса Updatable.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen implements Updatable {

        @Override
        public void onSelect() {

        }

        @Override
        public void refresh() {

        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen {


    }
}*/
