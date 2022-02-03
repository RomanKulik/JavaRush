package com.javarush.task.task23.task2303;

/* 
Запрети создание экземпляров класса
Запрети создание экземпляров класса
Запрети создание экземпляров класса Listener: public abstract static class Listener.


Requirements:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Класс Listener должен быть статическим.
4. Должна быть запрещена возможность создавать экземпляры класса Listener.
*/

public class Solution {

    public abstract static class Listener {

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

/*
package com.javarush.task.task23.task2303;

/*
Запрети создание экземпляров класса
Запрети создание экземпляров класса
Запрети создание экземпляров класса Listener.


Requirements:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Класс Listener должен быть статическим.
4. Должна быть запрещена возможность создавать экземпляры класса Listener.


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