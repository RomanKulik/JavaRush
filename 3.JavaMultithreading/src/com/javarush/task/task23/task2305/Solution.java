package com.javarush.task.task23.task2305;

/* 
Inner
Inner: s1.innerClasses[0] = new Solution().new InnerClass();
Реализовать метод getTwoSolutions, который должен возвращать
массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Requirements:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
/*
массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
 */
        Solution[] result = new Solution[2];

        Solution s1 = new Solution();
        s1.innerClasses[0] = new Solution().new InnerClass();
        s1.innerClasses[1] = new Solution().new InnerClass();

        Solution s2 = new Solution();
        s2.innerClasses[0] = new Solution().new InnerClass();
        s2.innerClasses[1] = new Solution().new InnerClass();

        result[0] = s1;
        result[1] = s2;

        return result;
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task23.task2305;

/*
Inner
Inner
Реализовать метод getTwoSolutions, который должен возвращать
массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Requirements:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        return null;
    }

    public static void main(String[] args) {

    }
}

*/
