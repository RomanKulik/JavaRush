package com.javarush.task.task11.task1115;

/* 
Увы, порой жизнь напоминает постепенный переход от одной стадии рабства в другую.
Сначала мы обязаны ходить в школу, потом — в университет, затем работать, работать, работать…
пока из работника не превратимся в раба! Разумеется, это не наш путь, поэтому мы и учимся программировать.
Пишем четыре класса и наследуем их друг от друга.

От школьника до квалифицированного раба
Изменить четыре класса: Schoolboy (школьник), Student (студент), Worker (Сотрудник), Slave (Раб).
Унаследовать студента от школьника, сотрудника от студента, раба от сотрудника.


Требования:
1. В классе Solution должен быть public класс Schoolboy (школьник).
2. В классе Solution должен быть public класс Student (студент).
3. В классе Solution должен быть public класс Worker (Сотрудник).
4. В классе Solution должен быть public класс Slave (Раб).
5. Класс Student должен быть унаследован от класса Schoolboy.
6. Класс Worker должен быть унаследован от класса Student.
7. Класс Slave должен быть унаследован от класса Worker.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Schoolboy {

    }

    public class Student extends Schoolboy {

    }

    public class Worker extends Student {

    }

    public class Slave extends Worker {

    }

}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class Schoolboy {

    }

    public class Student {

    }

    public class Worker {

    }

    public class Slave {

    }

}*/
