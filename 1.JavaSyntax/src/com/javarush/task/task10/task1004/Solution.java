package com.javarush.task.task10.task1004;

/* 
Что тут у нас, в секретном центре JavaRush?
У нас четвертая задача цикла «Преобразование целых типов».
Вот её краткое условие: даны short number = 9, char zero = ‘0’ и int nine = (zero + number).
Добавьте одну операцию по преобразованию типовт так, чтобы получился красивый правильный ответ nine = 9.
Думаем, справитесь.

Задача №4 на преобразование целых типов
Добавить одну операцию по преобразованию типа, чтобы получался ответ: nine=9
short number = 9;
char zero = ‘0’;
int nine = (zero + number);


Требования:
1. Программа должна выводить текст на экран.
2. Нельзя менять команду вывода на экран. Можно добавлять только операторы приведения типа.
3. Метод main() должен содержать переменную number типа short.
4. Метод main() должен содержать переменную zero типа char.
5. Метод main() должен содержать переменную nine типа int.
6. Начальное значение переменных при инициализации менять нельзя. Можно добавлять только операторы приведения типа.
7. Программа должна выводить число 9.
*/

public class Solution {
    public static void main(String[] args) {
        short number = 9;
        char zero = '0';
        //int nine = (Character.digit(zero, 10) + number);
        int nine = (zero + number);

//        System.out.println(number);
//        System.out.println(zero);
        System.out.println((char)nine);
    }
}

/*public class Solution {
    public static void main(String[] args) {
        short number = 9;
        char zero = '0';
        int nine = (zero + number);
        System.out.println(nine);
    }
}*/
