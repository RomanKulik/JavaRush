package com.javarush.task.task08.task0807;

import java.util.*;

/*

LinkedList и ArrayList

Коллекции могут быть реализованы разными способами и нет единственного – самого правильного.
При одном подходе одни операции являются быстрыми, а остальные медленными, при другом – все наоборот.
Нет одного идеального, подходящего всем решения.
Не будем мучится выбором и создадим сразу два списка — LinkedList и ArrayList.

LinkedList и ArrayList
Нужно создать два списка – LinkedList и ArrayList.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна содержать только три метода.
4. Метод createArrayList() должен создавать и возвращать список ArrayList.
5. Метод createLinkedList() должен создавать и возвращать список LinkedList.
*/

public class Solution {
    public static Object createArrayList() {
        //напишите тут ваш код
        return new ArrayList<>();
    }

    public static Object createLinkedList() {
        //напишите тут ваш код
        return new LinkedList<>();
    }

    public static void main(String[] args) {

    }
}
