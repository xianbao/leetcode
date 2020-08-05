package com.xiao.leetcode.serializationtest;

import java.io.*;

/**
 * @Auther: xxb
 * @Date: 2020/7/2 16:46
 * @Description: 序列化
 */
public class MySerialization {
    static class Student implements Serializable {
        private Integer age;

        public Student(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        private String name;

        @Override
        public String toString() {
            return "name:" + name + ";age:" + age;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化操作将类序列化为二进制文件
        FileOutputStream fileOutputStream = new FileOutputStream("student.out");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        Student student = new Student(10, "glp");
        out.writeObject(student);
        out.close();
        fileOutputStream.close();

        // 反序列化
        // 读取二进制文件
        FileInputStream fileInputStream = new FileInputStream("student.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student stu = (Student) objectInputStream.readObject();
        System.out.println(stu.toString());
        fileInputStream.close();
        objectInputStream.close();
    }


}
