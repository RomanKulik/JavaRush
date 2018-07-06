package com.javarush.task.task17.task1718;

/* 
Глажка
Глажка
И снова быт...
Поставьте один synchronized,
чтобы diana и igor гладили по очереди, ведь утюг всего один!

Подсказка:
использовать блокировку на уровне класса.


Требования:
1. Класс Solution должен содержать public static класс Clothes.
2. Класс Solution должен содержать public static класс Iron.
3. Класс Solution должен содержать public static класс Person.
4. Класс Person должен быть нитью.
5. В методе run() класса Person должен быть synchronized блок.
6. Synchronized блок должен использовать блокировку на уровне класса.

Да потому что это же ООП и это нелогично блин:
у тебя есть 1 утюг, и есть 2 Person.
Блокируя весь класс Person.class ты нецелесообразно
запрещаешь второму Person не занятому глажкой,
пойти борщ сварить или в гараж, или что там ещё другая нить
может делать пока Утюг занят.
Занимаешь Утюг? блокируй утюг, а не что попало.
*/
public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
        diana.start();
        igor.start();
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
            System.out.println(Thread.currentThread().getName() + " in run");
            synchronized (Iron.class) {
                System.out.println(Thread.currentThread().getName() + " in synch");
                Iron iron = takeIron();
                Clothes clothes = takeClothes();
                ironing(iron, clothes);
                returnIron();
                System.out.println(Thread.currentThread().getName() + " out of synch");
            }
            System.out.println(Thread.currentThread().getName() + " out of run");
        }

        protected  Iron takeIron() {
            System.out.println("Taking an Iron");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Returning the Iron");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void ironing(Iron iron, Clothes clothes) {
            System.out.println(getName() + "'s ironing the " + clothes.name);
        }
    }

    public static class Iron {
       /* private static Iron instance;

        private Iron() {
           // getInstance();
        }

        public synchronized static Iron getInstance() {
            if (instance == null)
                instance = new Iron();
            return instance;
        }*/
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
        diana.start();
        igor.start();
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
        }

        @Override
        public void run() {
            Iron iron = takeIron();
            Clothes clothes = takeClothes();
            ironing(iron, clothes);
            returnIron();
        }

        protected Iron takeIron() {
            System.out.println("Taking an Iron");
            return new Iron();
        }

        protected Iron returnIron() {
            System.out.println("Returning the Iron");
            return new Iron();
        }

        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void ironing(Iron iron, Clothes clothes) {
            System.out.println(getName() + "'s ironing the " + clothes.name);
        }
    }

    public static class Iron {
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}*/
