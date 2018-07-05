package com.javarush.task.task09.task0912;

/*

Исключение при работе с числами

Очередное задание по захвату исключений поступило сегодня в секретный центр JavaRush.
В этот раз нам придеться перехватить исключение, и сразу же вывести его на экран консоли.
Не забыть указать его тип.
А возникать оно будет при выполнении кода: int num=Integer.parseInt("XYZ"); System.out.println(num).

Исключение при работе с числами
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
int num=Integer.parseInt("XYZ");
System.out.println(num);


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
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int num = Integer.parseInt("XYZ");
        System.out.println(num);

        //напишите тут ваш код
    }
}*/
