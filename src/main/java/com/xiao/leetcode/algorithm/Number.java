package com.xiao.leetcode.algorithm;

/**
 * @Auther: xxb
 * @Date: 2020/3/4 09:49
 * @Description:
 */
public class Number {

    public boolean isNumber(String s) {

        return true;
    }

    private boolean isValidCharater(char ch) {
        return ch == '+' || ch == '-' || ch == '.' || ch == 'e' || (ch >= '0' && ch <= '9');
    }
}
