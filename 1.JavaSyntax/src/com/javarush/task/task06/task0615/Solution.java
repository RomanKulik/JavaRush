package com.javarush.task.task06.task0615;

/* 

Феншуй и статики

Специалист по программистскому феншую несколько секунд пристально изучал код программы,
затем приподнял одну бровь, кивнул и торжественно произнес:
«Я увидел ошибочность расположения модификаторов в этом коде.
Нужно переставить один модификатор static. Тогда всё будет по феншую.
Пример скомпилируется. Гармония восстановится».

Феншуй и статики
Переставь один модификатор static, чтобы пример скомпилировался.


Требования:
1. Метод main менять нельзя.
2. Добавь модификатор static в нужное место.
3. Убери лишний модификатор static.
4. В программе должно быть только 2 модификатора static.
*/

public class Solution {

    public static int A = 5;
    public int B = 2;
    public  int C = A * B;

    public static void main(String[] args) {
        A = 15;
    }
}

/*
public class Solution {

    public int A = 5;
    public int B = 2;
    public static int C = A * B;

    public static void main(String[] args) {
        A = 15;
    }
}
*/
