package com.javarush.task.task09.task0910;

import org.w3c.dom.ranges.RangeException;

import java.util.ArrayList;

/* 

Исключение при работе с коллекциями List

К девятому уровню мы уже получили некоторое представление о коллекциях List, и об исключениях.
Свяжем эти знания воедино: перехватим исключения при выполнении следующего кода
[ArrayList&lt;String&gt; list = new ArrayList&lt;String&gt;(); String s = list.get(18);].
Перехватим, и выведем на экран с указанием его типа.

Исключение при работе с коллекциями List
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
ArrayList<String> list = new ArrayList<String>();
String s = list.get(18);


Требования:
1. Программа должна выводить сообщение на экран.
2. В программе должен быть блок try-catch.
3. Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
4. Выведенное сообщение должно содержать тип возникшего исключения.
5. Имеющийся код в методе main не удалять.

*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
          try {
                ArrayList<String> list = new ArrayList<String>();
                String s = list.get(18);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e);
            }
          /*catch (IndexOutOfBoundsException e) {
              System.out.println("IndexOutOfBoundsException");
          }*/

            //Напишите тут ваш код
    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>();
        String s = list.get(18);

        //напишите тут ваш код
    }
}*/
