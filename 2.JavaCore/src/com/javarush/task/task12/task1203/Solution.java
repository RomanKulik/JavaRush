package com.javarush.task.task12.task1203;

/* 
Не вызывает сомнения то, что коты и собаки — это животные.
И их потомки должны быть животными.
Но не просто животными, а совершенно конкретными животными, котами и собаками.
Согласны?
В таком случае, переопределите метод getChild в классах Cat и Dog, чтобы кот порождал кота, а собака – собаку.
Кесарю — кесарево
Переопределить метод getChild в классах Cat(кот) и Dog(собака), чтобы кот порождал кота, а собака – собаку.


Требования:
1. Класс Cat должен наследоваться от класса Pet.
2. Класс Dog должен наследоваться от класса Pet.
3. Класс Cat должен переопределять метод getChild() чтобы кот порождал кота.
4. Класс Dog должен переопределять метод getChild() чтобы собака порождала собаку.
5. Метод main() должен вызывать метод getChild() у объекта типа Cat.
6. Метод main() должен вызывать метод getChild() у объекта типа Dog.
*/
public class Solution {
    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();

        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {
        @Override
        public Cat getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
       @Override
        public Dog getChild () {
            return new Dog();
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Pet pet1 = new Cat();
        Pet cat = pet1.getChild();

        Pet pet2 = new Dog();
        Pet dog = pet2.getChild();
    }

    public static class Pet {
        public Pet getChild() {
            return new Pet();
        }
    }

    public static class Cat extends Pet {

    }

    public static class Dog extends Pet {

    }
}*/
