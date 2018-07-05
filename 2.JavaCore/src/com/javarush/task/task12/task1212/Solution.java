package com.javarush.task.task12.task1212;

/* 
Этой задачей мы открываем сериал, в котором у вас — главная роль!
Так вот, главный герой — умелый программист-новичок,
которому предстоит разобраться с кодом нерасторопного коллеги.
В конце все жили долго и счастливо, а программа компилируется.

«Исправь код», часть 1
Исправь код, чтобы программа компилировалась.

Подсказка:
метод getChild должен остаться абстрактным.


Требования:
1. Класс Pet должен быть статическим.
2. Класс Pet должен иметь два метода.
3. Метод getChild() должен быть абстрактным.
4. Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.
*/
public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}*/
