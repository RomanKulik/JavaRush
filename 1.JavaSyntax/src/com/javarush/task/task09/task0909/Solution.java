package com.javarush.task.task09.task0909;

/* 

Исключение при работе с массивами

Осваиваем механизм для контроля над ошибками в программе. Исключения, то бишь.
На этот раз ваше задание — ловля исключений при работе с массивами.
В приложении есть такие строчки кода: [int[] m = new int[2]; m[8] = 5;].
Перехватите исключение, возникающее при выполнении этого кода, выведите его на экран и укажите его тип.

Исключение при работе с массивами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int[] m = new int[2];
m[8] = 5;


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

        int[] m = new int[2];
        try {
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int[] m = new int[2];
        m[8] = 5;


        //напишите тут ваш код
    }
}*/
