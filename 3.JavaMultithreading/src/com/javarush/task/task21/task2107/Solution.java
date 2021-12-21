package com.javarush.task.task21.task2107;

/*
Глубокое клонирование карты
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Requirements:
1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.
*/

/*
Глубокое клонирование карты
*/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Solution implements Cloneable {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (getClass() != o.getClass()) return false;
            if (!(o instanceof User)) return false;

            User other = (User) o;
            //if (name != null ? !name.equals(other.name) : name != null) return false;
            Objects.equals(name, other.name);
            return age == other.age;
        }

        @Override
        public int hashCode() {
            /*int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;*/
            return Objects.hash(age, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution o = new Solution();

        Map<String, User> newMap = new LinkedHashMap<>();
        for (String key : users.keySet()) {
            User newUser = users.get(key);
            newMap.put(key, (User) newUser.clone());
        }
        o.users = newMap;

        return o;
    }
}


/*
package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Глубокое клонирование карты
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Requirements:
1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}

 */