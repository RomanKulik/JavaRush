package com.javarush.task.task13.task1308;

/* 
Эй, ты там живой?
Ответ на этот вопрос должна выдавать программа, которую вам предстоит написать.
Для этого создайте интерфейс Person и добавьте в него метод isAlive(),
который должен будет сообщать о наличии признаков жизни объекта Person.
Догадаетесь, результат какого типа должен возвращать этот метод?

Эй, ты там живой?
1. Создай интерфейс Person.
2. Добавь в него метод isAlive(), который проверяет, жив человек или нет.
3. Подумай, какой тип должен возвращать этот метод.
4. Создай интерфейс Presentable.
5. Унаследуй интерфейс Presentable от интерфейса Person.


Требования:
1. В классе Solution должен быть объявлен интерфейс Person.
2. В классе Solution должен быть объявлен интерфейс Presentable.
3. Интерфейс Presentable должен наследоваться от интерфейса Person.
4. В интерфейсе Person должен быть объявлен метод isAlive.
5. Тип возвращаемого значения метода isAlive может иметь только два значения.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Person {
        Boolean isAlive();
    }

    interface Presentable extends Person {}
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
