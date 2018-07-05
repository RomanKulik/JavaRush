package com.javarush.task.task12.task1207;

/* 
В конце первого квеста вы узнали,
что для каждого примитивного класса в Java существует его непримитивный аналог.
Скоро эти непримитвные будут везде, помяните моё слово!
А пока — напишем два разных метода вывода на экран, один для примитивного типа int,
второй — для непримитивного Integer.

Int и Integer
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.


Требования:
1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический метод print() с параметром типа int.
3. Класс Solution должен содержать статический метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.
*/
public class Solution {
    public static void main(String[] args) {
        print(5);
        print(new Integer(4));
    }

    //Напишите тут ваши методы
    public static void print(int i) {}

    public static void print(Integer integer) {}
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
}*/
