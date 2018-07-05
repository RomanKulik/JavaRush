package com.javarush.task.task11.task1111;

/* 
Давайте создадим виртуального человека и назовём его, по традиции, Адамом.
И чтобы ему не было одиноко, напишем ему класс-наследник по имени Ева.
Может, у нас всё получается вовсе не так, как в библейской истории, но мы к этому и не стремимся.
Мы просто начинаем постигать такую важную часть ООП, как наследование.

«Из ребра его»
Изменить два класса Adam (Адам) и Eve (Ева).
Унаследовать Еву от Адама.


Требования:
1. В классе Solution должен быть класс Adam (Адам).
2. Класс Adam должен быть public.
3. В классе Solution должен быть класс Eve (Ева).
4. Класс Eve должен быть public.
5. Класс Eve должен быть унаследован от класса Adam.
*/
public class Solution {
    public static void main(String[] args) {
    }

    //Адам
    public class Adam {

    }

    //Ева
    public class Eve extends Adam{

    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    //Адам
    public class Adam {

    }

    //Ева
    public class Eve {

    }
}*/
