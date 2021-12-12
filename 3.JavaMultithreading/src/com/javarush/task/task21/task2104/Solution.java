package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode
в соответствии с правилами реализации этих методов
(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении
с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.


Requirements:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны
у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.

Выпуск 22. hashCode() и equals() - самое главное.
https://www.youtube.com/watch?v=ZcZQEqxmjOQ&t=485s&ab_channel=%D0%98%D0%B7%D1%83%D1%87%D0%B0%D0%B5%D0%BCJava
Руководство по String pool в Java
https://topjava.ru/blog/rukovodstvo-po-string-pool-v-java
Как сгенерировать hashCode в Java
http://www.seostella.com/ru/article/2012/10/04/kak-sgenerirovat-hashcode-v-java.html
Переопределение методов equals() и hashCode() в Java
https://javarush.ru/groups/posts/1340-peregruzka-metodov-equals-i-hashcode-v-java
Equals и сравнение строк
https://javarush.ru/groups/posts/equals-java-sravnenie-strok

Способ правильного переопределения equals(Object o) приведен в
Хорстманн т.1 2019, п.5.2.3, стр.221,
плюс важное замечание по типичным ошибкам на стр.222 приведено
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Solution)) return false;

        Solution solution = (Solution) obj;
        if (!Objects.equals(first, solution.first))
            return false;
        return Objects.equals(last, solution.last);

        /*
        if (this.first != null ? !first.equals(solution.first) : solution.first != null)
            return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
         */
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));


    }
}

/*
package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/*
Equals and HashCode
Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.


Requirements:
1. Хешкоды одинаковых объектов должны быть равны.
2. Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
3. Метод equals должен проверять является ли переданный объект объектом класса Solution.
4. Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь что они могут быть равны null).
5. Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.


public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}

 */