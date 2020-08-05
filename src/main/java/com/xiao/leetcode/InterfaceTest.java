package com.xiao.leetcode;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.xiao.leetcode.interfacetest.Cat;
import com.xiao.leetcode.interfacetest.Dog;
import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * @Auther: xxb
 * @Date: 2020/6/28 11:44
 * @Description:
 */
public class InterfaceTest implements Dog, Cat {

    // 编写单利模式
    // 饿汉式单利
    /**
     * private static final InterfaceTest instance = new InterfaceTest();
     * public static InterfaceTest getInstance() {return instance;}
     */
    // 懒汉式
    /**
     * private static InterfaceTest lazyInstance;
     * public static InterfaceTest getInstance() {
     * if (lazyInstance == null) lazyInstance = new InterfaceTest();
     * return lazyInstance;
     * }
     */
    // 双重判断

    /**
     * private static volatile InterfaceTest instance;
     * public static InterfaceTest getInstance() {
     * if (instance == null) {
     * synchronized (InterfaceTest.class) {
     * if (instance == null) {
     * instance = new InterfaceTest();
     * }
     * }
     * }
     * return instance;
     * }
     */

    @Override
    public void run() {
        System.out.println("hello world");
    }

    static class Father {
        static {
            System.out.println("father static function");
        }

        {
            System.out.println("father normal function");
        }

        public Father() {
            System.out.println("father construction");
        }
    }

    static class Son extends Father {
        {
            System.out.println("son normal function");
        }

        static {
            System.out.println("son static function");
        }

        public Son() {
            System.out.println("son construction");
        }
    }

    static ThreadLocal<String> testLocal = new ThreadLocal<>();

    static class ThreadTest implements Runnable {

        @Override
        public void run() {
            testLocal.set("hello");
            testLocal.set("world");
            System.out.println(testLocal.get());
        }
    }

    public static void main(String[] args) throws IOException {
        // 读取文件流
        InputStream inputStream = new FileInputStream("");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int n;
        if ((n = inputStream.read(buffer)) != -1) {
            stream.write(buffer, 0, n);
        }
        stream.toByteArray();

        Thread thread = new Thread(new ThreadTest());
        thread.start();
    }
}
