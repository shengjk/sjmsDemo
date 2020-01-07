package xmht.javabase.xuliehua;

import java.io.*;

/*
transient ：用该关键字修改的字段，表示 不序列化 该字段
serialPersistentFields : 表示只序列化这里指定的字段。注意，这里的优先级，高于 transient 。即，只要这里指定了序列化的，即使在该字段里用了 transient 来修饰，该字段也会进行序列化
 */
public class Test {
    public static void main(String[] args) {
        write();
        read();
    }
    private static final void read() {
        try {
            PersonA personA = new PersonA();
            FileInputStream fileIn =
                    new FileInputStream("personA.out");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            personA = (PersonA) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(personA);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PersonB personB = new PersonB();
            FileInputStream fileIn =
                    new FileInputStream("personB.out");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            personB = (PersonB) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(personB);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static final void write() {
        try {
            PersonA personA = new PersonA();
            FileOutputStream fileOut =
                    new FileOutputStream("personA.out");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(personA);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            PersonB personB = new PersonB();
            FileOutputStream fileOut =
                    new FileOutputStream("personB.out");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(personB);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static class PersonA implements Serializable {
        private String hello = "Hello World";
        transient private Integer age = 18;
        public String getHello() {
            return hello;
        }
        public void setHello(String hello) {
            this.hello = hello;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "personA[" + hello + ", " + age + "]";
        }
    }
    public static class PersonB implements Serializable {
        private String hello = "Hello World";
        transient private Integer age = 18;
        private static final ObjectStreamField[] serialPersistentFields =
                new ObjectStreamField[1];
        static {
            serialPersistentFields[0] = new ObjectStreamField("age", Integer.class);
        }
        public String getHello() {
            return hello;
        }
        public void setHello(String hello) {
            this.hello = hello;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "personB[" + hello + ", " + age + "]";
        }
    }
}
