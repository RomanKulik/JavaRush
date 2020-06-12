package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        //1) создать файл
        File file = new File("test_file.bin");

        //открыть поток на чтение (input stream) и на запись(output stream);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream is = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(is)) {

            //2) создать экземпляр класса Solution - savedObject;
            Solution savedObject = new Solution(32);

            //3) записать в поток на запись savedObject
            oos.writeObject(savedObject);
            // (убедитесь, что они там действительно есть);
            System.out.println("savedObject:\t" + savedObject);

            //4) создать другой экземпляр класса Solution с другим параметром;
            Solution otherSolution = new Solution(10);
            System.out.println("otherSolution:\t" + otherSolution);

            //5) загрузить из потока на чтение объект - loadedObject;
            Solution loadedObject = (Solution) ois.readObject();
            System.out.println("loadedObject:\t" + loadedObject);

            //6) проверить, что savedObject.string равна loadedObject.string;
            System.out.println(savedObject.string.equals(loadedObject.string));
            System.out.println();
            System.out.println("savedObject after:\t" + savedObject);
            System.out.println("loadedObject after:\t" + loadedObject);

            //7) обработать исключения.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}


/*
package com.javarush.task.task20.task2014;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.


Требования:
1. Поле pattern должно быть отмечено модификатором transient.
2. Поле currentDate должно быть отмечено модификатором transient.
3. Поле temperature должно быть отмечено модификатором transient.
4. Поле string НЕ должно быть отмечено модификатором transient.
*/
/*
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
    }

    private final String pattern = "dd MMMM yyyy, EEEE";
    private Date currentDate;
    private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

 */