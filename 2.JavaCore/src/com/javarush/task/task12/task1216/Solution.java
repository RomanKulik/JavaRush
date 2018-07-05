package com.javarush.task.task12.task1216;

/* 
Учитель JavaRush Риша Гейтсман на лекциях говаривал,
что интерфейс есть законное дитя Абстракции и Полиморфизма.
Начинаем его изучать. Вы когда-нибудь летали во сне? Мечтали о полёте наяву?
Вот вам задачка: реализуйте интерфейс полёта с двумя методами. Справитесь?

Летать охота
Напиши свой public интерфейс Fly(летать).
Добавь в него два метода.


Требования:
1. Класс Solution должен содержать интерфейс Fly.
2. Интерфейс Fly должен быть публичным.
3. Интерфейс Fly должен содержать два метода.
4. Интерфейс Fly не должен иметь родителя.
*/
public class Solution {
    public static void main(String[] args) {

    }

    //add an interface here - добавь интерфейс тут
    public interface Fly {
        public void up();
        public void down();
    }
}
/*public class Solution {
    public static void main(String[] args) {

    }

    //add an interface here - добавь интерфейс тут
}*/
