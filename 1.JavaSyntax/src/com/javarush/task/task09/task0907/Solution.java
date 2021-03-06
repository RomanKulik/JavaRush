package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами

Уважаемые коллеги, всё серьезно, начинаем операцию по перехвату исключений.
Из секретного центра JavaRush поступило следующее задание, цитирую:
«Перехватить исключение (и вывести его на экран), указав его тип,

Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int a = 42 / 0;


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
            int a = 42 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int a = 42 / 0;

        //напишите тут ваш код
    }
}*/
