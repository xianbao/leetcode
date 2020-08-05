package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: xxb
 * @Date: 2020/6/3 17:20
 * @Description:
 */
public class ThreadTest {
    // 顺序执行多线程
    private ReentrantLock reentrantLock;
    private Integer times;
    private Integer state;

    public ThreadTest(ReentrantLock reentrantLock, Integer times) {
        this.times = times;
        this.reentrantLock = reentrantLock;
        this.state = 0;
    }

    /**
     * 方法一：使用reentrantLock
     */
    private void print(String value, int n, Condition current, Condition next) {
        reentrantLock.lock();
        try {
            for (int i = 0; i < times; i++) {
                if (state % 3 != n) {
                    current.await();
                }
                state += 1;
                System.out.print(value);
                next.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void function1(ReentrantLock lock) {
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        new Thread(() -> print("a", 0, condition1, condition2)).start();
        new Thread(() -> print("b", 1, condition2, condition3)).start();
        new Thread(() -> print("c", 2, condition3, condition1)).start();
    }

    /**
     * 方法二：使用线程池，定义单线程的线程池执行
     */
    public void function2() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            int count = 30;
            while (count-- > 0) {
                executor.submit(() -> System.out.print("a"));
                executor.submit(() -> System.out.print("b"));
                executor.submit(() -> System.out.print("c"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }


    /**
     * 方法三：使用countDownLatch,只能使用一次
     */
    public void function3() {
        CountDownLatch latch1 = new CountDownLatch(0);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);
        new Thread(()->print3("a", 0, latch1, latch2)).start();
        new Thread(()->print3("b", 1, latch2, latch3)).start();
        new Thread(()->print3("c", 2, latch3, latch1)).start();

    }
    public void print3(String value, Integer n, CountDownLatch current, CountDownLatch next) {
        try {
            for (int i = 0; i < times; i++) {
                if (state % 3 != n)
                    current.await();
                System.out.print(value);
                state += 1;
                current = new CountDownLatch(1);
                next.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(String.join(",", set).length());
//        ReentrantLock lock = new ReentrantLock();
//        ThreadTest object = new ThreadTest(lock, 30);
//        object.function1(lock);
//        object.function2();
//        object.function3();
    }
}
