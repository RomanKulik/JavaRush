package com.javarush.task.task11.task1104;

/* 
Даже самый главный босс когда-то был зелёным новичком.
Давайте представим, что вы попали на работу в должности секретаря, но мечтаете со временем быть управляющим.
Что общего между вами, управляющим и директором?
Все они — сотрудники.
В этой задачке нужно создать класс «Сотрудник», и унаследовать от него всех остальных.

Хороши работнички
Написать четыре класса: Employee (сотрудник), Manager (управляющий), Chief (директор) и Secretary (секретарь).
Унаследовать управляющего, директора и секретаря от сотрудника.


Требования:
1. В классе Solution должен быть public класс Employee (сотрудник).
2. В классе Solution должен быть public класс Manager (управляющий).
3. В классе Solution должен быть public класс Chief (директор).
4. В классе Solution должен быть public класс Secretary (секретарь).
5. Класс Manager должен быть унаследован от класса Employee.
6. Класс Chief должен быть унаследован от класса Employee.
7. Класс Secretary должен быть унаследован от класса Employee.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Manager extends Employee {

    }

    public class Chief extends Employee {

    }

    public class Employee {

    }

    public class Secretary extends Employee {

    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class Manager {

    }

    public class Chief {

    }

    public class Employee {

    }

    public class Secretary {

    }
}*/
