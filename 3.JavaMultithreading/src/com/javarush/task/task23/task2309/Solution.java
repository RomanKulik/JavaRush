package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
Анонимность иногда так приятна!
1. В пакете vo создай public классы User, Location,
Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создай свой метод,
который возвращает список экземпляров класса.

Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()

3. Внутри каждого такого метода создай анонимный класс от
AbstractDbSelectExecutor и вызови его нужный метод.

Подсказка:
тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'

5. Проанализируй пример вывода и сформируй правильный query для всех классов.


Requirements:
1. В пакете vo должен быть создан public класс User, унаследованный от класса NamedItem.
2. В пакете vo должен быть создан public класс Location, унаследованный от класса NamedItem.
3. В пакете vo должен быть создан public класс Server, унаследованный от класса NamedItem.
4. В пакете vo должен быть создан public класс Subject, унаследованный от класса NamedItem.
5. В пакете vo должен быть создан public класс Subscription, унаследованный от класса NamedItem.
6. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа User.
7. В методе getLocations должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Location.
8. В методе getServers должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Server.
9. В методе getSubjects должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Subject.
10. В методе getSubscriptions должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Subscription.
11. Метод getUsers должен возвращать корректный список(в соответствии с условием задачи).
12. Метод getLocations должен возвращать корректный список(в соответствии с условием задачи).
13. Метод getServers должен возвращать корректный список(в соответствии с условием задачи).
14. Метод getSubjects должен возвращать корректный список(в соответствии с условием задачи).
15. Метод getSubscriptions должен возвращать корректный
список(в соответствии с условием задачи).
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public List<User> getUsers(){
        return new AbstractDbSelectExecutor(){
            @Override
            public String getQuery() {
                return null;
            }
        }.execute();
    }
    public List<Location> getLocations(){return null;}
    public List<Server> getServer(){return null;}
    public List<Subject> getSubject(){return null;}
    public List<Subscription> getSubscription(){return null;}

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(
                    format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}


/*
package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/*
Анонимность иногда так приятна!
Анонимность иногда так приятна!
1. В пакете vo создай public классы User, Location,
Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создай свой метод,
который возвращает список экземпляров класса.

Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()

3. Внутри каждого такого метода создай анонимный класс от
AbstractDbSelectExecutor и вызови его нужный метод.

Подсказка:
тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'

5. Проанализируй пример вывода и сформируй правильный query для всех классов.


Requirements:
1. В пакете vo должен быть создан public класс User, унаследованный от класса NamedItem.
2. В пакете vo должен быть создан public класс Location, унаследованный от класса NamedItem.
3. В пакете vo должен быть создан public класс Server, унаследованный от класса NamedItem.
4. В пакете vo должен быть создан public класс Subject, унаследованный от класса NamedItem.
5. В пакете vo должен быть создан public класс Subscription, унаследованный от класса NamedItem.
6. В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа User.
7. В методе getLocations должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Location.
8. В методе getServers должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Server.
9. В методе getSubjects должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Subject.
10. В методе getSubscriptions должен быть создан объект класса AbstractDbSelectExecutor
с параметром типа Subscription.
11. Метод getUsers должен возвращать корректный список(в соответствии с условием задачи).
12. Метод getLocations должен возвращать корректный список(в соответствии с условием задачи).
13. Метод getServers должен возвращать корректный список(в соответствии с условием задачи).
14. Метод getSubjects должен возвращать корректный список(в соответствии с условием задачи).
15. Метод getSubscriptions должен возвращать корректный
список(в соответствии с условием задачи).


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}

 */