package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*

Коллекция HashMap из котов

Мы тут решили собрать коллекцию котов, и составить для неё правильный КОТолог.
В этой программке кто-то уже потрудился написать класс Cat с полем имя (name).
Наша задача — создать коллекцию HashMap, и добавить в неё 10 котов. Для начала хватит.
В качестве ключа, как вы, наверное, уже догадались, следует использовать имя кота.

Коллекция HashMap из котов
Есть класс Cat с полем имя (name, String).
Создать коллекцию HashMap<String, Cat>.
Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота.
Вывести результат на экран, каждый элемент с новой строки.


Требования:
1. Объяви переменную коллекции HashMap с типом элементов String, Cat и
сразу проинициализируй ee.
2. Программа не должна считывать значения с клавиатуры.
3. Метод addCatsToMap()должен добавлять в коллекцию 10 котов, согласно условию.
4. Программа должна выводить содержимое коллекции на экран,
каждую пару через дефис и с новой строки.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        //напишите тут ваш код
        HashMap<String, Cat> tmpMap = new HashMap<>();
        for (int i = 0; i < cats.length; i++) {
            Cat cat = new Cat(cats[i]);
            tmpMap.put(cats[i], cat);
        }
        return tmpMap;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        //напишите тут ваш код

    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}*/
