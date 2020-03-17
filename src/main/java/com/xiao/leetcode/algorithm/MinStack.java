package com.xiao.leetcode.algorithm;

import java.util.Stack;

/**
 * @Auther: xxb
 * @Date: 2020/3/4 17:31
 * @Description:
 */
class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }





    public static void main(String[] args) {
        MinStack object = new MinStack();
        object.push(512);
        object.push(-1024);
        object.push(-1024);
        object.push(512);
        object.pop();
        System.out.println(object.min());
        object.pop();
        System.out.println(object.min());
        object.pop();
        System.out.println(object.min());

    }
}
