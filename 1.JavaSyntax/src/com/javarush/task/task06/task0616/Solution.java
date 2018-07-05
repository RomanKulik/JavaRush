package com.javarush.task.task06.task0616;

/* 

Минимальное число статиков

Разминать мозги полезно, а делать это лучше всего с помощью головоломок.
Но поскольку мы — программисты, головоломки мы помещаем прямо в код.
Вот, держите: в коде этой задачки нужно расставить минимальное количество static’ов так,
чтобы код начал работать и программа успешно завершилась.

Минимальное число статиков
Расставьте минимальное количество static-ов, чтобы код начал работать, и программа успешно завершилась.


Требования:
1. Реализацию методов менять нельзя.
2. Добавь модификаторы static в нужные места.
3. В программе должно быть только 4 модификатора static.
4. Программа должна выводить текст на экран.
*/

public class Solution {
    public static int step;

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        new Solution().method3();
    }

    public void method3() {
        method4();
    }

    public void method4() {
        step++;
        for (StackTraceElement element : Thread.currentThread().getStackTrace())
            System.out.println(element);
        if (step > 1)
            return;
        main(null);
    }
}
