package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * CRUD 2
 * CrUD Batch - multiple Creation, Updates, Deletion
 * Программа запускается с одним из следующих наборов параметров:
 * -c name1 sex1 bd1 name2 sex2 bd2 ...
 * -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
 * -d id1 id2 id3 id4 ... -i id1 id2 id3 id4 ...
 * Значения параметров: name - имя, String sex - пол, "м" или
 * <p>
 * CRUD 2
 * CrUD Batch - multiple Creation, Updates, Deletion
 * <p>
 * Программа запускается с одним из следующих наборов параметров:
 * -c name1 sex1 bd1 name2 sex2 bd2 ...
 * -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
 * -d id1 id2 id3 id4 ...
 * -i id1 id2 id3 id4 ...
 * <p>
 * Значения параметров:
 * name - имя, String
 * sex - пол, "м" или "ж", одна буква
 * bd - дата рождения в следующем формате 15/04/1990
 * <p>
 * -с - добавляет всех людей с заданными параметрами в конец allPeople,
 * выводит id (index) на экран в соответствующем порядке
 * -u - обновляет соответствующие данные людей с заданными id
 * -d - производит логическое удаление человека с id, заменяет все его данные на null
 * -i - выводит на экран информацию о всех людях с заданными id: name sex bd
 * id соответствует индексу в списке
 * <p>
 * Формат вывода даты рождения 15-Apr-1990
 * <p>
 * Все люди должны храниться в allPeople
 * <p>
 * Порядок вывода данных соответствует вводу данных
 * Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
 * <p>
 * Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
 * <p>
 * Пример вывода для параметра -і с двумя id:
 * Миронов м 15-Apr-1990
 * Миронова ж 25-Apr-1997
 * <p>
 * <p>
 * Требования:
 * 1. Класс Solution должен содержать public static volatile поле allPeople типа List.
 * 2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
 * 3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
 * 4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
 * 5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
 * 6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
 * 7. Метод main класса Solution должен содержать оператор switch по значению args[0].
 * 8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
 */
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static final SimpleDateFormat SDF_IN = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat SDF_OUT = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //printAllUsers();

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    cCreateUser(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    uUpdateUser(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    dDeleteUser(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    iPrintUserById(args);
                }
                break;
            default:
                // synchronized (allPeople) {
                System.out.println("Invalid params in command line");
                //}
        }
    }

    //printAllUsers();

    private static void cCreateUser(String[] args) {
        //-c name1 sex1 bd1 name2 sex2 bd2 ...
        // -c Вася м 13/12/1985 Ульяна ж 30/12/1994 Ляшко оно хз
        String[] tmp = new String[args.length - 1];
        System.arraycopy(args, 1, tmp, 0, Math.min(args.length, tmp.length)); // // без учета параметра командной строки
        //System.out.println(Arrays.toString(tmp));

        for (int i = 0; i < tmp.length; i += 3) {
            String name = tmp[i + 0];
            String sex = tmp[i + 1];
            try {
                Date bd = SDF_IN.parse(tmp[i + 2]);
                Person p = sex.equals("м") ?
                        Person.createMale(name, bd) : Person.createFemale(name, bd);
                allPeople.add(p);
                System.out.println(allPeople.indexOf(p));
            } catch (Exception e) {
                System.out.println("User " + name + " was not added, because: \n" + e);
            }
        }
    }

    private static void uUpdateUser(String[] args) {
        //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
        // -u 0 Вася м 13/12/1985 1 Ульяна ж 30/12/1994 2 Ляшко оно хз

        String[] tmp = new String[args.length - 1];
        System.arraycopy(args, 1, tmp, 0, Math.min(args.length, tmp.length));

        for (int i = 0; i < tmp.length; i += 4) {
            String name = tmp[i + 1];
            String sex = tmp[i + 2];
            try {
                int id = Integer.parseInt(tmp[i + 0]);
                Date bd = SDF_IN.parse(tmp[i + 3]);
                Person p = sex.equals("м") ?
                        Person.createMale(name, bd) : Person.createFemale(name, bd);
                allPeople.remove(id);
                allPeople.add(id, p);
            } catch (Exception e) {
                System.out.println("User " + name + " was not updated, because: \n" + e);
            }

        }
    }

    private static void dDeleteUser(String[] args) {
        //-d id1 id2 id3 id4 ...
        // -d 0 1
        Person p;
        for (int i = 1; i < args.length; i++) {
            try {
                int id = Integer.parseInt(args[i]);
                if (args[i] == null) continue;
                p = allPeople.get(i);
                p.setName(null);
                p.setSex(null);
                p.setBirthDay(null);
                allPeople.remove(id);
                allPeople.add(id, p);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    private static void iPrintUserById(String[] args) {
        //-i id1 id2 id3 id4 ...
        //Миронов м 15-Apr-1990
        //Миронова ж 25-Apr-1997
        // -i 0 1
        Person p;
        for (int i = 1; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);
            p = allPeople.get(id);
            System.out.println(
                    p.getName() + " "
                            + (p.getSex().equals(Sex.MALE) ? "м" : "ж") + " "
                            + SDF_OUT.format(p.getBirthDay())
            );
        }
    }

    private static void printAllUsers() {
        System.out.println("size: " + allPeople.size());
        for (Person p :
                allPeople) {
            System.out.println(p);
        }
    }
}
/*public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
    }
}*/
