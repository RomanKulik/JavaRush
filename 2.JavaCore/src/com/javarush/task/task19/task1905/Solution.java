package com.javarush.task.task19.task1905;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada


Требования:
1. Класс Solution должен содержать public static поле countries типа Map.
2. В статическом блоке класса Solution инициализируй поле countries
тестовыми данными согласно заданию.
3. Класс Solution должен содержать интерфейс RowItem.
4. Класс Solution должен содержать интерфейс Contact.
5. Класс Solution должен содержать интерфейс Customer.
6. Класс DataAdapter должен реализовывать интерфейс RowItem.
7. Класс DataAdapter должен содержать два приватных поля:
customer типа Customer и contact Contact.
8. Класс DataAdapter должен содержать конструктор с параметрами
(Customer customer, Contact contact), который инициализирует поля contact и customer.
9. В классе DataAdapter реализуй методы интерфейса
RowItem используя подсказки в виде комментариев в интерфейсах.
*/
public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //new DataAdapter().getDialString();
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter() {
        }

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> entry : countries.entrySet())
                if (entry.getValue().equals(this.customer.getCountryName()))
                    return entry.getKey();
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return this.contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return this.contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
           return "callto://+"+contact.getPhoneNumber().
                   replaceAll("[\\D]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
/*
public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    public static void main(String[] args) {

    }

    public static class DataAdapter {
        public DataAdapter(Customer customer, Contact contact) {
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}*/
