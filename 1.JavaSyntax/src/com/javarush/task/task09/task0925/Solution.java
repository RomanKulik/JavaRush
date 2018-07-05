package com.javarush.task.task09.task0925;

/*

Статики не на своем месте

Послышались мелкие шаги, и в комнате появился мастер Ю Ву, специалист по расстановке.
Хмуро он посмотрел на код, и сказал то, что боялся услышать программист:
«Статики не там, где они нужны. Вот в чем ошибка твоя».
Мастер прав: расставьте модификаторы static так, чтобы программа скомпиллировалась.

Статики не на своем месте
Расставь модификаторы static так, чтобы пример скомпилировался.


Требования:
1. В классе должна быть переменная A.
2. В классе должна быть переменная B.
3. В классе должна быть переменная C.
4. Метод main не изменять.
5. Метод getA не изменять.
6. В классе должно быть 3 статических поля.
*/
public class Solution {
    public static int A = 5;
    public static int B = 2 * A;
    public int C = A * B;
    public static int D = A * B;

    public static void main(String[] args) {
        Solution room = new Solution();
        room.A = 5;

        Solution.D = 5;
    }

    public int getA() {
        return A;
    }

}
/*public class Solution {
    public int A = 5;
    public int B = 2 * A;
    public int C = A * B;
    public int D = A * B;

    public static void main(String[] args) {
        Solution room = new Solution();
        room.A = 5;

        Solution.D = 5;
    }

    public int getA() {
        return A;
    }

}*/
