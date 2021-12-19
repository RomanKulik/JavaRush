package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.


Requirements:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен проверять значения всех полей у переданного объекта и текущего
(учти что некоторые из них могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.

https://javarush.ru/tasks/com.javarush.task.task21.task2106#discussion мой коммент + конспект по Equals, hashCode
*/

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(){}

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.aDouble = aDouble;
        this.string = string;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (!(this.getClass().getName().equals(o.getClass().getName()))) return false;
        if (!(o instanceof Solution)) return false;

        Solution other = (Solution) o;
        if (Double.compare(aDouble, other.aDouble) != 0) return false;
        if (!Objects.equals(string, other.string)) return false;
        if (!Objects.equals(date, other.date)) return false;
        if (!Objects.equals(solution, other.solution)) return false;
        return  anInt == other.anInt;

        /*if (Double.compare(aDouble, other.aDouble) != 0) return false;
        if (date != null ? !date.equals(other.date) : other.date != null) return false;
        if (string != null ? !string.equals(other.string) : other.string != null) return false;
        if (solution != null ? !solution.equals(other.solution) : other.solution != null) return false;
        return anInt == other.anInt;
        // or
        return string != null ? !string.equals(solution1.string) : solution1.string == null;
        */

    }

    @Override
    public int hashCode() {
       /* int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;*/
       return Objects.hash(anInt, aDouble, string, date, solution);
    }

    public static void main(String[] args) {

    }
}

// https://javarush.ru/tasks/com.javarush.task.task21.task2106#discussion
/*
Из этой задачи мы поняли:

Не переопределенный equals сравнивает ссылки.
Если обе ссылки = null, вернет true.

Оператор сравнения if сделает return false только в том случае, когда в скобке будет true.

if (date != null ? !date.equals(other.date) : other.date != null) return false;



if (date != null ? !date.equals(other.date) : other.date != null) return false;
тоже, что и
if (!Objects.equals(date, other.date)) return false;



Переменные типа double сравниваются через статический метод класса Double, который возвращает
-1, 0, 1

if (Double.compare(aDouble, other.aDouble) != 0) return false;



По сути equals сравнивает поля класса.
При переопределении метода equals (а если его, то переопределяем и hashCode) должны использоваться все [значимые] поля класса

В начале метода equals должны быть такие проверки:

// Хорстман:
 if (this == other) return true; // сравнение по ссылкам
 if (o == null) return false; // сравнение other с null

 // Если семантика проверки может измениться в подклассе
 if (!(this.getClass().getName().equals(other .getClass().getName()))) return false;
 // Если семантика одинакова для всех подклассов
 if (!(other instanceof Solution)) return false;

 // сравнение всех полей класса
 // примитивные типы сравниваем через ==
// float преобразовываем в int через floatToIntBits() и сравниваем через ==
// double преобразовываем в long через doubleToLongBits() и сравниваем через ==
// объекты через equals()
// поля типа массивов (как примитивов, так и Object-ов): Arrays.equals()

hashCode - это число типа int (4 байта)!
По умолчанию определяется по адресу памяти, занимаемой объектом.
Может быть как положительным, так и отрицательным.
Поэтому:

long  temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
 int  result = 31 * result + (int) (temp ^ (temp >>> 32));


Чтобы посчитать хэш-код восьмибайтного числа, нужно произвести исключающее побитовое «или» (xor) старшей половины числа с младшей: (int) (x ^ (x >>> 32)).

Вместо множителя 31 может быть любое, желательно простое число: 7, 11, 13, 29..., потому что математически высчитано, что такие множители дают наибольший разброс при формировании hashCode. Применение четных чисел, особенно степеней 2 может привести к некорректной работе массивов и прочих коллекций.

Для примитивных и ссылочных типов: java.lang.hashcode(type/Type val)
т.ж. hashCode у примитивных типов может быть как их значение, так и их значение, умноженное на простое число

Object.hashCode() - null небезопасен! throw java.lang.NullPointerException

Objects.hashCode(obj) - вернет 0, если obj = null, иначе вызовет предыдущий метод: obj.hashCode()

Objects.hash(obj1, obj2,...) - вернет hashCode состоящий из hashCode-ов переданных объектов

Для получения hashCode массивов используем: Arrays.hashCode(type[] arr)

// Переопределяемый метод hashCode() можно записать в одну строку:

@Override
    public int hashCode() {
       int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;

       // или в одну строку:
       return Objects.hash(anInt, aDouble, string, date, solution);
    }
*/

/*
package com.javarush.task.task21.task2106;

import java.util.Date;

/*
Ошибка в equals/hashCode
Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.


Requirements:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что некоторые из них могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
6. В классе Solution должен быть реализован метод hashCode.


public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Solution) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

    }
}

 */