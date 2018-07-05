package com.javarush.task.task14.task1403;

/* 
Building и School
Есть просто здание, а есть здание школы.
Унаследуйте одно от другого, и подумайте,
объект какого класса должен возвращать методы getSchool и getBuilding.
Измените null на объект класса Building или School.

Building и School
1. Расставь правильно наследование между Building(здание) и School(здание школы).
2. Подумай, объект какого класса должен возвращать методы getSchool и getBuilding.
3. Измени null на объект класса Building или School.


Требования:
1. Класс School должен наследоваться от класса Building.
2. Метод getSchool должен возвращать новую школу(School).
3. Метод getBuilding должен возвращать новое здание(Building).
4. Класс School должен быть статическим.
5. Класс Building должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return new School();
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return new Building();
    }

    static class School extends Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building /*Добавьте сюда ваш код*/ {
        @Override
        public String toString() {
            return "Building";
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Building school = getSchool();
        Building shop = getBuilding();

        System.out.println(school);
        System.out.println(shop);
    }

    public static Building getSchool() {
        //измените null на объект класса Building или School
        return null;
    }

    public static Building getBuilding() {
        //измените null на объект класса Building или School
        return null;
    }

    static class School *//*Добавьте сюда ваш код*//* {
        @Override
        public String toString() {
            return "School";
        }
    }

    static class Building *//*Добавьте сюда ваш код*//* {
        @Override
        public String toString() {
            return "Building";
        }
    }
}*/
