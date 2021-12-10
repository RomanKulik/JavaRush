package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
Все гениальное - просто!
Упростить.
Переменные не переименовывать, комментарии не оставлять.


Requirements:
1. Метод calculate должен быть статическим.
2. Метод calculate должен возвращать значение типа boolean.
3. Метод calculate должен принимать четыре параметра типа boolean.
4. Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).

http://vgpl5.by/ovt/text/teory/4/4-5.htm
https://www.youtube.com/watch?v=5U4P56A2ePY&ab_channel=Kirsanov2011
https://programforyou.ru/calculators/postroenie-tablitci-istinnosti-sknf-sdnf
https://wiki.livid.pp.ru/students/cs/lectures/8.html
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        //return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task21.task2103;

/*
Все гениальное - просто!
Все гениальное - просто!
Упростить. Переменные не переименовывать, комментарии не оставлять.


Requirements:
1. Метод calculate должен быть статическим.
2. Метод calculate должен возвращать значение типа boolean.
3. Метод calculate должен принимать четыре параметра типа boolean.
4. Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).


public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {

    }
}

 */