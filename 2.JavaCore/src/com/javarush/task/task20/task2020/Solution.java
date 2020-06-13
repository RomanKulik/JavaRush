package com.javarush.task.task20.task2020;

/*
Сериализация человека
Сериализуй класс Person стандартным способом.
При необходимости добавь некоторым полям модификатор transient.


Требования:
1. Класс Person должен поддерживать интерфейс Serializable.
2. Поле fullName должно быть отмечено модификатором transient.
3. Поле greeting должно быть отмечено модификатором transient.
4. Поле outputStream должно быть отмечено модификатором transient.
5. Поле logger должно быть отмечено модификатором transient.
6. Поле firstName НЕ должно быть отмечено модификатором transient.
7. Поле lastName НЕ должно быть отмечено модификатором transient.
8. Поле country НЕ должно быть отмечено модификатором transient.
9. Поле sex НЕ должно быть отмечено модификатором transient.
*/

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 Идея в том, что имея параметризованный конструктор Person(...)
 восстановление объекта может быть выполнено с использованием этого конструктора =)
 То есть вначале загружается легковесный сериализованный "огрызок"
 с минимально необходимым набором полей/данных, а уже затем, если нужно,
 объект окончательно восстанавливается путем инициализации new Person(...)
 со всеми необходимыми параметрами, взятыми из загруженной заготовки.
 Например, вот так:

 // recovering the person
 Person loadedPersonStub = (Person) objectInputStream.readObject();
 Person reconstructedPerson = new Person(
 loadedPersonStub.firstName,
 loadedPersonStub.lastName,
 loadedPersonStub.country,
 loadedPersonStub.sex
 );


 Ну, и вызвав что-нибудь наподобие

 System.out.println(
 reconstructedPerson.greetingString +
 reconstructedPerson.fullName
 );


 можно убедиться, что (OMG) отмеченное как transient поле final String greetingString
 успешно инициализировалось в восстановленном объекте (что очевидно) =)
 */

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task20.task2020;

import java.io.PrintStream;
import java.util.logging.Logger;

/*
Сериализация человека
Сериализуй класс Person стандартным способом.
При необходимости добавь некоторым полям модификатор transient.


Требования:
1. Класс Person должен поддерживать интерфейс Serializable.
2. Поле fullName должно быть отмечено модификатором transient.
3. Поле greeting должно быть отмечено модификатором transient.
4. Поле outputStream должно быть отмечено модификатором transient.
5. Поле logger должно быть отмечено модификатором transient.
6. Поле firstName НЕ должно быть отмечено модификатором transient.
7. Поле lastName НЕ должно быть отмечено модификатором transient.
8. Поле country НЕ должно быть отмечено модификатором transient.
9. Поле sex НЕ должно быть отмечено модификатором transient.
*/
/*
public class Solution {

    public static class Person {
        String firstName;
        String lastName;
        String fullName;
        final String greeting;
        String country;
        Sex sex;
        PrintStream outputStream;
        Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {

    }
}

 */