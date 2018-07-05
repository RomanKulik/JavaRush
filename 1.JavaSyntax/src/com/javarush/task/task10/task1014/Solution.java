package com.javarush.task.task10.task1014;

/* 
Минимум статиков, максимум результата, — таков девиз вашего следующего задания.
В нем вам придеться проанализировать уже написанный кем-то добрым код, и понять,
где этот добрый человек забыл поставить статики.
Код-то не компилируется.


Расставьте минимум static-ов
Расставьте как можно меньше модификаторов static так, чтобы пример скомпилировался.


Требования:
1. В классе должна быть переменная A.
2. В классе должна быть переменная B.
3. В классе должна быть переменная C.
4. В классе должна быть переменная D.
5. Метод main не изменять.
6. Метод getA не изменять.
*/
public class Solution {
    public int A = 5;
    public static int B = 5;
    public static int C = 5;
    public static int D = 5;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.A = 5;
        solution.B = 5 * B;
        solution.C = 5 * C * D;
        Solution.D = 5 * D * C;

        Solution.D = 5;
    }

    public int getA() {
        return A;
    }

}
/*public class Solution {
    public int A = 5;
    public int B = 5;
    public int C = 5;
    public static int D = 5;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.A = 5;
        solution.B = 5 * B;
        solution.C = 5 * C * D;
        Solution.D = 5 * D * C;

        Solution.D = 5;
    }

    public int getA() {
        return A;
    }

}*/
