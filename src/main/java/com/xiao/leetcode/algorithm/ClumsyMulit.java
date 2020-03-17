package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: xxb
 * @Date: 2020/1/16 14:57
 * @Description: 自定义阶乘
 */
public class ClumsyMulit {

    public int clumsy(int N) {
        if (N == 1) return 1;
        int result;
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        List<Integer> list = new ArrayList<>();
        List<String> symbol = new ArrayList<>();


        // 计数器，标志操作符
        int count = 0;
        N -= 1;
        while (N > 0) {
            int first = stack.pop();
            if (count == 0) {
                stack.push(first * N);
                if (N == 1) {
                    list.add(stack.peek());
                }
                count += 1;
            } else if (count == 1) {
                stack.push(first / N);
                if (N == 1) {
                    list.add(stack.peek());
                }
                count += 1;
            } else if (count == 2) {
                list.add(first);
                list.add(N);
                stack.push(first);
                stack.push(N);
                symbol.add("+");
                count += 1;
            } else if (count == 3) {
                stack.push(first);
                stack.push(N);
                symbol.add("-");
                if (N == 1) {
                    list.add(stack.peek());
                }
                count = 0;
            }

            N -= 1;
        }
        result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (symbol.get(i - 1).equals("+")) {
                result += list.get(i);
            } else {
                result -= list.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ClumsyMulit clumsyMulit = new ClumsyMulit();
        System.out.println(clumsyMulit.clumsy(5));
    }

}
