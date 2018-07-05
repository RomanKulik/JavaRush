package com.javarush.task.task17.task1710;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя,
String sex - пол, "м" или "ж",
одна буква bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными п

CRUD
CrUD - Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок,
в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с
программа должна добавлять человека с заданными параметрами
в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u
программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d
программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i
программа должна выводить на экран
данные о человеке с заданным id по формату указанному в задании.
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    private static final SimpleDateFormat SDF_IN = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat SDF_OUT = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        printAllPeople();

        switch (args[0]) {
            case "-c":
                cCreateUser(args);
                break;
            case "-u":
                uUpdateUserById(args);
                break;
            case "-d":
                dDeleteUserById(Integer.parseInt(args[1]));
                break;
            case "-i":
                iGetUserById(Integer.parseInt(args[1]));
                break;
        }

        printAllPeople();
        // iGetUserById(allPeople.size() - 1);
    }

    private static void cCreateUser(String[] args) throws ParseException {
        //-c Мурзикова ж 01/01/1991
        Person p;
        String name = args[1];
        String sex = args[2];
        Date date = SDF_IN.parse(args[3]);

        if (sex.equals("м")) {
            p = Person.createMale(name, date);
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        } else if (sex.equals("ж")) {
            p = Person.createFemale(name, date);
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        } else {
            System.out.println("No such sex");
        }
    }

    private static void uUpdateUserById(String[] args) throws ParseException {
        //-u 0 Миронов м 15/04/1990
        //-u 1 Миронова ж 16/05/1991
        int id = Integer.parseInt(args[1]);
        Person p;
        String name = args[2];
        String sex = args[3];
        Date date = SDF_IN.parse(args[4]);

        if (sex.equals("м")) {
            p = Person.createMale(name, date);
            allPeople.remove(id);
            allPeople.add(id, p);
        } else if (sex.equals("ж")) {
            p = Person.createFemale(name, date);
            allPeople.remove(id);
            allPeople.add(id, p);
        } else {
            System.out.println("No such sex");
        }
    }

    private static void dDeleteUserById(int id) {
        //-d 1
        Person p = allPeople.get(id);
        p.setName(null);
        p.setSex(null);
        p.setBirthDay(null);
        allPeople.remove(id);
        allPeople.add(id, p);
    }

    private static void iGetUserById(int id) {
        //Миронов м 15-Apr-1990
        //-i 1
        Person p = allPeople.get(id);
        System.out.println(p.getName() + " "
                + (p.getSex().equals(Sex.MALE) ? "м" : "ж") + " "
                + SDF_OUT.format(p.getBirthDay()));
    }

    private static void printAllPeople() {
        System.out.println("size: " + allPeople.size());
        /*for (int i = 0; i < allPeople.size(); i++) {
            iGetUserById(i);
        }*/
        for (Person p :
                allPeople) {
            System.out.println(p);
        }
    }
}
/*public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}*/
