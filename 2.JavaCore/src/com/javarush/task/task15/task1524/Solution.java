package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
Итак, полезная задачка на отладку.
У вас есть код, в котором нужно разобраться:
узнайте, что и в какой последовательности инициализируется.
Для этого можно использовать отладчик в IntelliJ IDEA и его брейкпоинты.
Затем исправьте порядок инициализации так, чтобы получить определённый результат.

Порядок загрузки переменных
Разберись, что и в какой последовательности инициализируется.
Поставь брейкпойнты и используй дебаггер.

Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init() 1
Static block 2
public static void main 3
non-static block 4
static void printAllFields 5
0 6
null 7
Solution constructor 8
static void printAllFields 9
6 10
First name 11


Требования:
1. Программа должна выводить данные на экран.
2. Вывод на экран должен соответствовать условию задачи.
3. Результатом работы статического инициализатора класса
Solution должен быть вывод на экран строк "static void init()" и "Static block".
4. Программа не должна считывать данные с клавиатуры.
*/

/*
* Порядок инициализации таков:

    Статические элементы родителя
    Статические элементы наследника
    Глобальные переменные родителя
    Конструктор родителя
    Глобальные переменные наследника
    Конструктор наследника

    Еще было бы неплохо указать,
    что статические переменные(да и вообще весь статический контент)
    инициализируется когда классЛоадер впервые натыкается на этот класс.
    А все другие переменные уже при вызову конструктора.

    вас смутило то, что я в порядке указал конструктор родителя раньше наследника?
    Дело в том, что первым делом, при чтении конструктора наследника,
    вызывается конструктор родителя.
    Так что справедливее писать именно так

    static void init() 1
Static block 2
public static void main 3
non-static block 4
static void printAllFields 5
0 6
null 7
Solution constructor 8
static void printAllFields 9
6 10
First name 11
*/
public class Solution {
    public static void init() {
        System.out.println("static void init()");
    }
    static { //1
        init();
    }
    static { //2
        System.out.println("Static block");
    }
    public static void main(String[] args) { //3
        System.out.println("public static void main");
        Solution s = new Solution();
    }


    { // 4
        System.out.println("non-static block");
        printAllFields(this);
    }
    public int i = 6; // 10
    public String name = "First name"; // 11

    public static void printAllFields(Solution obj) { // 5
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }


    public Solution() { // 8
        System.out.println("Solution constructor");
        printAllFields(this);
    }




}
/*public class Solution {
    static {
        System.out.println("Static block");
    }

    {
        System.out.println("non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";
    static {
        init();
    }

    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.name);
        System.out.println(obj.i);
    }
}*/
