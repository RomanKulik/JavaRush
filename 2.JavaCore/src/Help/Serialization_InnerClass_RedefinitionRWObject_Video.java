package Help;

import java.io.*;

public class Serialization_InnerClass_RedefinitionRWObject_Video implements Serializable {

    public Serialization_InnerClass_RedefinitionRWObject_Video() {
        // ВАЖНО ! ! !
    }

    public static class A {

        public A() {
            // ВАЖНО ! ! !
        }

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        // ВАЖНО ! ! !
        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(this.nameA);
        }

        // ВАЖНО ! ! !
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            this.nameA = String.valueOf(ois.readObject());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Serialization_InnerClass_RedefinitionRWObject_Video solution =
                new Serialization_InnerClass_RedefinitionRWObject_Video();
        Serialization_InnerClass_RedefinitionRWObject_Video.B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        Serialization_InnerClass_RedefinitionRWObject_Video.B b1 =
                (Serialization_InnerClass_RedefinitionRWObject_Video.B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}

