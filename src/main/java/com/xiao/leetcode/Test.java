package com.xiao.leetcode;

import com.xiao.leetcode.util.ListNode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: xxb
 * @Date: 2020/3/28 13:46
 * @Description:
 */
public class Test {

//    private ReentrantLock reentrantLock;
//    private Integer times;
//    private Integer state;
//
//    public Test(Integer times, ReentrantLock reentrantLock) {
//        this.times = times;
//        this.reentrantLock = reentrantLock;
//        this.state = 0;
//    }

    public static boolean isPalindrome(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode node = head;
        ListNode temp;
        while (node != null) {
            temp = node.next;
            node.next = p.next;
            p.next = node;
            node = temp;
        }
        ListNode q = p.next;

        node = head;
        while (q != null) {
            if (q.val != node.val) return false;
            q = q.next;
            node = node.next;
        }
        return true;
    }

    // 计算一个字符串最少经过多少次操作可以变为目标字符串


    public static int calOperateCount(String src, String target) {
        int[][] dp = new int[src.length() + 1][target.length() + 1];
        for (int i = 0; i < src.length() + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < target.length() + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= src.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (src.charAt(i - 1) == target.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[src.length()][target.length()];
    }


    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private String getString(StringBuilder sb, int length, char[] arr) {
        sb.delete(0, length + 1);
        for (int index = 0; index <= length; index++) {
            sb.append(arr[index]);
        }
        String result = sb.toString();
        return result;
    }

    public String[] permutation(String S) {
        // 使用字典排序
        char[] arr = new char[S.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.charAt(i);
            sb.append(S.charAt(i));
        }
        // 对数组按照字符大小进行升序排序
        Arrays.sort(arr);
        List<String> temp = new ArrayList<>();
        int length = S.length() - 1;

        temp.add(getString(sb, length, arr));

        while (true) {
            boolean find = false;
            for (int i = length; i > 0; i--) {
                // 查找第一个升序的字符
                if (arr[i] > arr[i - 1]) {
                    find = true;
                    // 找到目标以后，从后往前找，查找第一个大于i-1位置的元素，然后交换
                    for (int j = length; j > i - 1; j--) {
                        if (arr[j] > arr[i - 1]) {
                            swap(arr, i - 1, j);
                            // i-1后的元素需要逆序
                            for (int left = i, right = length; left <= right; left++, right--) {
                                swap(arr, left, right);
                            }
                            break;
                        }
                    }
                    temp.add(getString(sb, length, arr));
                    break;
                }
            }
            if (!find) break;
        }

        String[] result = new String[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }

        return result;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int start = 0;
        int maxLength = 1;
        int index;
        for (int i = 1; i < s.length(); i++) {
            if ((index = findDuplicate(start, i, s))!= -1) {
                maxLength = Math.max(maxLength, i - start);
                start = index + 1;
            }
        }

        return  Math.max(s.length() - start, maxLength);
    }

    private int findDuplicate(int start, int end, String s) {
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == s.charAt(end)) return i;
        }
        // end之前字符串中，不存在index=end时的字符
        return -1;
    }

    public static void main(String[] args) throws IOException {
//        Test object = new Test();
//        System.out.println(object.lengthOfLongestSubstring("aab"));
        int a = 10;
        int b = 3;
        System.out.println((double) a / b);

        // 读取文件, 首先是按照字节流读取
//        InputStream in = new FileInputStream("");
//        // 建立字节缓冲流
//        InputStream buffer = new BufferedInputStream(in);
//        // 按照行读取字符流
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("/Users/xiao/Desktop/test.txt"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) reader.close();
//        }
    }

    public synchronized void testFunc1() {
        System.out.println("this is test---1 function !");
    }

    public synchronized void testFunc2() {
        System.out.println("this is test---2 function !");
    }

    private int value;

    public void add() {
        for (int i = 0; i < 5; i++) {
            value += 1;
            System.out.println(Thread.currentThread().getName() + ":" + value);
        }
    }

}
