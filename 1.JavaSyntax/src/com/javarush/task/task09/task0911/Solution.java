package com.javarush.task.task09.task0911;

import java.util.HashMap;

/*

Исключение при работе с коллекциями Map

У нас есть сомнительный код, пора запускать агента по перехвату исключений.
Вот он, наш код:[ HashMap&lt;String, String&gt; map = new HashMap&lt;String, String&gt;(null); map.put(null, null); map.remove(null);].
Агент, ваше задание, как обычно, заключается в перехвате исключения и выводе его на экран.
Не забудьте только при выводе указать тип этого исключения.

Исключение при работе с коллекциями Map
Перехватить исключение (и вывести его на экран), указав его тип, возникающее при выполнении кода:
HashMap<String, String> map = new HashMap<String, String>(null);
map.put(null, null);
map.remove(null);


Требования:
1. Программа должна выводить сообщение на экран.
2. В программе должен быть блок try-catch.
3. Программа должна отлавливать исключения конкретного типа, а не все возможные (Exception).
4. Выведенное сообщение должно содержать тип возникшего исключения.
5. Имеющийся код в методе main не удалять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try {
            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

            HashMap<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);

        //напишите тут ваш код
    }
}*/
