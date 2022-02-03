package com.javarush.task.task23.task2302;

/* 
Запрети переопределение
Запрети переопределение
Запрети переопределение метода onMouseDown: public final void onMouseDown(int x, int y).


Requirements:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Метод onMouseDown должен быть публичным.
4. Должна быть запрещена возможность переопределить метод onMouseDown.
*/

public class Solution {

    public static class Listener {
        public final void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task23.task2302;

/*
Запрети переопределение
Запрети переопределение
Запрети переопределение метода onMouseDown.


Requirements:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Метод onMouseDown должен быть публичным.
4. Должна быть запрещена возможность переопределить метод onMouseDown.


public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}

 */