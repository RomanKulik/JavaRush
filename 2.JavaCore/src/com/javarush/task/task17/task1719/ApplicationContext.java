package com.javarush.task.task17.task1719;

import java.util.HashMap;
import java.util.Map;

/* 
ApplicationContext
ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись:
подумай, какое ключевое слово необходимо поставить и где.


Требования:
1. Класс ApplicationContext должен быть абстрактным.
2. Класс ApplicationContext должен содержать private поле container типа Map.
3. В getByName(String name), если необходимо, используй synchronized.
4. В removeByName(String name), если необходимо, используй synchronized.

Представьте, что геттер начал читать данные,
где-то внутри метода HashMap уже получена на них ссылка,
но прочитать не успел и нить остановилась, чтобы дать поработать другим нитям.
В это время другая нить удалила эту запись (которую читает геттер).
После этого геттер продолжил свою работу и читает уже непонятно что .
когда ynchronized один заблокирован другие тоже заблокированы
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
        return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}

/*public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public GenericsBean getByName(String name) {
          return container.get(name);
    }

    public GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}*/
