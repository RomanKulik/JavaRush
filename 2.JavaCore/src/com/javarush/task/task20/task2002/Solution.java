package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load
должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load
должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.

enum(String str)
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
Date formatDate = simpleDateFormat.parse("01 01 2000");
            user.setBirthDate(formatDate);
            
SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
user.setBirthDate(sdf.parse(reader.readLine()));
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("d:/1", null);
            File your_file_name = new File("d:/1.tmp");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here -
            //инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            // javaRush.users.add(null);
            javaRush.users.add(new User());
            javaRush.users.add(new User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object -
            //проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));
           /* System.out.println(javaRush.users);
            System.out.println(loadedObject.users);*/

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file: " + e);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method: " + e);
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            int len = this.users.size();
            if (len == 0) {
                System.out.println("User list is empty");
                return;
            }

            int nullCount = Collections.frequency(this.users, null);
            //System.out.println(len - nullCount);
            //pw.println(len - nullCount);
            for (int i = 0; i < len; i++) { // записывать, пропуская null объекты
                try {
                    User u = users.get(i);
                    if (u != null) {
                        //pw.println(u);
                        pw.println(u.getFirstName());
                        pw.println(u.getLastName());
                       /* SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy h:mm:ss");
                        pw.println(sdf.format(u.getBirthDate()));*/
                        pw.println(u.getBirthDate().getTime());
                        pw.println(u.isMale());
                        pw.println(u.getCountry());
                    }
                } catch (Exception ignore) {
                }
            }
            pw.flush();
            // Serialization
            /*ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            if (users.size() != 0) {
                oos.writeInt(users.size());
            } else {
                System.out.println("User list is empty");
                return;
            }
            for (User u : users)
                oos.writeObject(u);*/
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            try {
                // int len = Integer.parseInt(br.readLine());
                //if (len == 0) throw new NumberFormatException();
                while (br.ready()) {
                    User user = new User();
                    user.setFirstName(br.readLine());
                    user.setLastName(br.readLine());
                    //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    //user.setBirthDate(sdf.parse(br.readLine()));
                   /* DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy h:mm:ss");
                    Date date = (Date) formatter.parse(br.readLine());*/
                    user.setBirthDate(new Date(Long.parseLong(br.readLine())));
                    user.setMale(Boolean.parseBoolean(br.readLine()));
                    user.setCountry(User.Country.valueOf(br.readLine()));
                    users.add(user);
                }
            } catch (NumberFormatException e) {
                System.out.println("The file does not contain a User list");
            }
            // Serialization
            /*  ObjectInputStream ois = new ObjectInputStream(inputStream);
            try {
                int len = ois.readInt();
                if (len != 0)
                    for (int i = 0; i < len; i++)
                        users.add((User) ois.readObject());
            } catch (IOException e){
                System.out.println("The file does not contain a User list");
            }*/
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}*/
