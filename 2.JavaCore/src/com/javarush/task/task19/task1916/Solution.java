package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов,
где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        ) {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            while (file1.ready()) list1.add(file1.readLine());
            while (file2.ready()) list2.add(file2.readLine());
            while (!list1.isEmpty() || !list2.isEmpty()) {
                if (list2.isEmpty()) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (list1.isEmpty()) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                } else if (list1.get(0).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                }
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // рабочее, но не проходит.
    /*public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        ) {
            String s1 = file1.readLine(), s2 = file2.readLine(); // строка из файла 1 и из файла 2
            while (true) {
                if (s1 == null || s2 == null) {
                    if (s1 == null && s2 == null) break; // оба файла вычитаны
                    if (s1 == null) {// первый файл вычитан, читаем только второй файл
                        lines.add(new LineItem(Type.ADDED, s2));
                        s2 = file2.readLine();
                    } else if (s2 == null) { // второй файл вычитан, читаем только первый файл
                        lines.add(new LineItem(Type.REMOVED, s1));
                        s1 = file1.readLine();
                    }
                } else {
                    if (s1.compareTo(s2) == 0) {
                        lines.add(new LineItem(Type.SAME, s1));
                        s1 = file1.readLine();
                        s2 = file2.readLine();
                    } else if (s1.compareTo(s2) < 0) {
                        lines.add(new LineItem(Type.REMOVED, s1));
                        s1 = file1.readLine();
                    } else if (s1.compareTo(s2) > 0) {
                        lines.add(new LineItem(Type.ADDED, s2));
                        s2 = file2.readLine();
                    } else {
                        System.out.println("s1 = " + s1 + "\t" + "s2 = " + s2 + "\t" + "equals: " + s1.equals(s2) + "\t" + "compareTo: " + s1.compareTo(s2));
                    }
                }
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }*/


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
}

/*public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        ) {
            while (true) {
                String s1 = file1.readLine();
                String s2 = file2.readLine();

                if (s1 == null && s2 == null)
                    break;
                if (*//*s1 != null && s2 != null &&*//* s1.equals(s2))
                    lines.add(new LineItem(Type.SAME, s1));
                else if (s1 == null || s1.equals(""))
                    lines.add(new LineItem(Type.ADDED, s2));
                else if (s2 == null || s2.equals(""))
                    lines.add(new LineItem(Type.REMOVED, s1));
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
}*/

/*public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter file3 = new BufferedWriter(new FileWriter(reader.readLine()))
        ) {
            List<String> tmp1 = new ArrayList<>();
            List<String> tmp2 = new ArrayList<>();
            while (file1.ready()) tmp1.add(file1.readLine());
            while (file2.ready()) tmp2.add(file2.readLine());
            //System.out.println(tmp1 + "\n" + tmp2);

            // добавление пустых строк в конец меньшего файла
            if (tmp1.size() > tmp2.size())
                for (int i = 0; i < tmp1.size() - tmp2.size(); i++)
                    tmp2.add("");
            if (tmp1.size() < tmp2.size())
                for (int i = 0; i < tmp2.size() - tmp1.size(); i++)
                    tmp1.add("");
            // System.out.println(tmp1.size() + "\t" + tmp2.size());

            for (int i = 0; i < Math.max(tmp1.size(), tmp2.size()); i++) {
                String s1 = tmp1.get(i);
                String s2 = tmp2.get(i);
                if (s2.equals(s1))
                    lines.add(new LineItem(Type.SAME, s2));
                else if (s1.length() == 0)
                    lines.add(new LineItem(Type.ADDED, s2));
                else if (s2.length() == 0)
                    lines.add(new LineItem(Type.REMOVED, s1));
            }

            //lines.forEach(System.out::println);
            *//*for (LineItem l : lines) { // запись lines в файл
                file3.write(l.toString());
                file3.write("\r\n");
            }*//*
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
}*/

/*public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}*/
