package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен присутствовать метод public static long[] getNumbers(long N)
2. В методе getNumbers не должно возникать исключений, при любых входных данных.
3. Все найденные числа должны быть строго меньше N.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
public class Solution {
    // Long.MAX_VALUE = 9223372036854775807

    public static long[] getNumbers(long N) {
        ArrayList<Long> longList = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            if (getArmstrongNumber(i) != 0) {
                longList.add(i);
            }
        }

        int longListSize = longList.size();
        long[] result = new long[longListSize];
        for (int i = 0; i < longListSize; i++) {
            result[i] = longList.get(i);
        }

        return result;
    }

    // Возвращает Число Армстронга или 0
    // 370 = 3*3*3 + 7*7*7 + 0*0*0
    // 8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
    public static long getArmstrongNumber(long N) {
        long sum = 0;
        long tmp = N;
        long number, pow;
        int nOfNumbersInN = getCountOfDigitsInNumber(N);

        while (tmp > 0) {
            pow = 1;
            number = tmp % 10;

            if (number == 0) {
                tmp /= 10;
                continue;
            }

            // возведение числа в степень
            for (int i = 0; i < nOfNumbersInN; i++) {
                pow *= number;
            }

            sum += pow;
            tmp /= 10;
        }
        return sum == N ? sum : 0;
    }

    // Возвращает количество цифр в числе
    public static int getCountOfDigitsInNumber(long N) {
        int counter = 0;
        long tmp = N;

        while (tmp > 0) {
            tmp /= 10;
            counter++;
        }
        return counter;
    }

    // Возвращает матрицу 10*N степеней
    public static long[][] getDegreeMatrix(long N) {
        long[][] result = new long[10][(int) N + 1];

        //System.out.print("\t\t");
        for (int i = 0; i <= N; i++) {
            //System.out.print(i + "\t\t");
        }
        //System.out.println();

        for (int i = 0; i < 10; i++) {
            //System.out.print(i + "\t\t");
            for (int j = 0; j <= N; j++) {
                result[i][j] = pow(i, j);
                //System.out.print(result[i][j] + "\t\t");
            }
            //System.out.println();
        }
        return result;
    }

    // Возводит в положительную степень только
    public static long pow(int number, int degree) {
        long result = 1;
        if (degree == 0 || number == 1) {
            return result;
        } else if (degree > 0) {
            for (int i = 0; i < degree; i++) {
                result *= number;
            }
            return result;
        }
        return 0;
    }

    // Возводит в отрицательную степень только
    public static double powNegative(int number, int degreeNegativeOnly) {
        double result = 1;
        if (degreeNegativeOnly < 0) {
            for (int i = 0; i < degreeNegativeOnly * -1; i++) {
                degreeNegativeOnly *= number;
            }
        }
        return 1 / (double) result;
    }

    // Возвращает сумму чисел, каждое из которых возведено в количество чисел в массиве
    public static long getSumOfDegreesOfNumbersInArray(long[] arr) {
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += Math.pow(arr[i], arr.length);
        }
        // System.out.println("result = " + result);
        return result;
    }

    // Возвращает массив чисел, из которых состоит long number
    // 370 -> [3, 7, 0]
    private static long[] getCountNumbers(long number) {
        int result = 0;
        long tmp = number;
        while ((tmp /= 10) != 0) {
            result++;
        }

        tmp = number;
        long[] resultArr = new long[++result];
        for (int i = 0; i < result; i++) {
            // проверка на ввод отрицательного числа
            resultArr[result - 1 - i] = tmp % 10 < 0 ? tmp % 10 * -1 : tmp % 10;
            tmp /= 10;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(getArmstrongNumber(8208));
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " +
                (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) /
                        /* (8 * 1024)*/(1000 * 1000) + " MB");
        System.out.println("time = " + (b - a) / 1000 + " s");

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000)));
       // System.out.println(Arrays.toString(getNumbers(  1_000_000_000)));
        // Long.MAX_VALUE =                                9_223_372_036_854_775_807
        //System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory()) / /*(8 * 1024)*/ (1000 * 1000) + " MB");
        System.out.println("time = " + (b - a) / 1000 + " s");
    }
}

/*
package com.javarush.task.task20.task2025;

import java.util.Arrays;

/*
Алгоритмы-числа
Число S состоит из M цифр, например, S=370 и M (количество цифр) = 3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания.

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен присутствовать метод public static long[] getNumbers(long N)
2. В методе getNumbers не должно возникать исключений, при любых входных данных.
3. Все найденные числа должны быть строго меньше N.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/
/*
public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}

 */