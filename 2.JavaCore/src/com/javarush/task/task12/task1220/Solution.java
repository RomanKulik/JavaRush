package com.javarush.task.task12.task1220;

/* 
В очередной раз мы, как истинные программисты, должны будем создать человека.
Причем, как всегда, путём написания кода. Увы.
И наградим мы нашего человека интерфейсами «бежать» и «плавать», но не реализуем их.
Ибо наш человек — абстрактен. Звучит понятно?
Если нет, пора перечитать лекции по абстрактным классам и интерфейсам.

Класс Human и интерфейсы Run, Swim
Напиши public класс Human(человек) и public интерфейсы Run(бежать/ездить), Swim(плавать).
Добавь в каждый интерфейс по одному методу.
Добавь эти интерфейсы классу Human, но не реализуй методы.
Объяви класс Human абстрактным.


Требования:
1. Класс Solution должен содержать интерфейс Run с одним методом.
2. Класс Solution должен содержать интерфейс Swim с одним методом.
3. Класс Solution должен содержать класс Human.
4. Класс Human должен реализовывать интерфейсы Run и Swim.
5. Класс Human должен быть абстрактным.
6. Класс Human не должен иметь методов.
*/
public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and public class here - добавь public интерфейсы и public класс тут
    public interface Run { public void run();}

    public interface Swim { public void swim();}

    public abstract class Human implements Run, Swim {};
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and public class here - добавь public интерфейсы и public класс тут

}*/
