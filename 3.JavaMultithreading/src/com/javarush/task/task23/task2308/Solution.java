package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
Рефакторинг, вложенные классы: public static final class, public static final String
Отрефакторите класс Solution:
вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.

!!!!!
только static переменные можно вызывать без создания экземпляра класса.
Только final класс нельзя наследовать,
а так же константа это по определению неизменяемое значение,
то к переменным так же используем параметр final.
!!!!!

Requirements:
1. В классе Solution должен быть создан
класс Constants содержащий строковые константы.
2. Класс Constants должен быть публичным.
3. Класс Constants должен быть объявлен с модификатором,
запрещающим наследование от этого класса.
4. В классе Constants должна существовать
константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со значением
"The server is not currently accessible.".
5. В классе Constants должна существовать
константа USER_IS_NOT_AUTHORIZED
со значением "The user is not authorized.".
6. В классе Constants должна существовать
константа USER_IS_BANNED со значением "The user is banned.".
7. В классе Constants должна существовать
константа ACCESS_IS_DENIED со значением "Access is denied.".
*/

public class Solution {
    public static final class Constants {
        public static final String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is not currently accessible.";
        public static final String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public static final String USER_IS_BANNED = "The user is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task23.task2308;

/*
Рефакторинг, вложенные классы
Рефакторинг, вложенные классы
Отрефакторите класс Solution:
вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.


Requirements:
1. В классе Solution должен быть создан
класс Constants содержащий строковые константы.
2. Класс Constants должен быть публичным.
3. Класс Constants должен быть объявлен с модификатором,
запрещающим наследование от этого класса.
4. В классе Constants должна существовать
константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со значением
"The server is not currently accessible.".
5. В классе Constants должна существовать
константа USER_IS_NOT_AUTHORIZED
со значением "The user is not authorized.".
6. В классе Constants должна существовать
константа USER_IS_BANNED со значением "The user is banned.".
7. В классе Constants должна существовать
константа ACCESS_IS_DENIED со значением "Access is denied.".


public class Solution {
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}

 */