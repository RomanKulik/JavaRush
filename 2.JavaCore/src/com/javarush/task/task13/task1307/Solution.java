package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
Помните дженерики, они же обобщения, они же — параметризированные типы?
Если нет, поройтесь в голове, затем в лекциях, затем — в Google.
Или в другом порядке.
А затем — посмотрите на код этой задачи и реализуйте интерфейс SimpleObject
с параметром типа String в классе StringObject.

Параметризованый интерфейс
В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.


Требования:
1. Класс StringObject должен реализовывать интерфейс SimpleObject.
2. Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
3. В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
4. Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> //допишите здесь ваш код
    {
        @Override
        public SimpleObject<String> getInstance() {
            return null;
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject //допишите здесь ваш код
    {
    }
}*/
