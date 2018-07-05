package com.javarush.task.task11.task1106;

/* 
В лекции по инкапсуляции Риша рассказал,
что порой несколько классов взаимодействуют с одним и тем же объектом,
в результате — нарушается целостность данных внутри этого объекта.
У нас есть кот. Нужно, чтобы все экземпляры кота остались целостными,
ибо никто не любит нецелостных котов!
Знаете, что делать?

Скрытный инкапсулированный кот
Скрыть все внутренние переменные класса Cat.


Требования:
1. Переменная name класса Cat должна быть скрыта.
2. Переменная age класса Cat должна быть скрыта.
3. Переменная weight класса Cat должна быть скрыта.
4. В классе Cat должны быть 3 переменные.
5. Все переменные класса Cat должны быть private.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age;
        private int weight;

        public Cat() {
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        public String name;
        public int age;
        public int weight;

        public Cat() {
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}*/

