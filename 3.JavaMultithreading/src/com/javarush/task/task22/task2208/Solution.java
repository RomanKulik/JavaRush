package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Формируем WHERE: Сформируй rчасть запроса WHERE используя StringBuilde.
Сформируй rчасть запроса WHERE используя StringBuilde.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Requirements:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную
по правилам описанным в условии задачи.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            if (key != null && val != null) {
                sb.append(key).append(" = '").append(val).append("'").append(" and ");
            } else {
                count++;
            }
        }

        // Убедись, что метод getQuery возвращает пустую строку, если во входящем Map все значения null.
        if (count == params.size())
            return "";

        String result = sb.toString();

        return result.substring(0, result.lastIndexOf(" and "));
    }

    // JavaRush Solution
    public static String getQueryJR(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }
}

/*
package com.javarush.task.task22.task2208;

import java.util.Map;

/*
Формируем WHERE
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Requirements:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную
по правилам описанным в условии задачи.


public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        return null;
    }
}

 */