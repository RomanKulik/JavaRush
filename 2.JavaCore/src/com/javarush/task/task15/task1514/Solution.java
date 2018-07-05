package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
В статическом блоке инициализировать labels 5
различными парами ключ-значение.
При этом в классе Solution должен быть только один метод(main),
там же нужно объявить статическое поле labels типа Map,
которое нужно заполнить 5 различными парами ключ-значение в статическом блоке.

Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.


Требования:
1. В классе Solution должен быть только один метод(main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
*/
public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0, "1.0");
        labels.put(2.0, "2.0");
        labels.put(3.0, "3.0");
        labels.put(4.0, "4.0");
        labels.put(5.0, "5.0");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
/*public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
}*/
