package com.xiao.leetcode.algorithm;

import javax.swing.plaf.metal.MetalTheme;
import java.util.*;

/**
 * @Auther: xxb
 * @Date: 2020/1/16 11:00
 * @Description: 最大可接雨水量
 */
public class WaterTrap {

    public int trap(int[] height) {
        int result = 0;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int rightIndex = height.length - 1;

        for (int i = 1; i < height.length - 1; i++) {
            if (i == 1 || i == rightIndex) {
                maxRight = height[height.length - 1];
                for (int k = height.length - 1; k > i; k--) {
                    if (maxRight < height[k]) {
                        maxRight = height[k];
                        rightIndex = k;
                    }
                }
            }
            result += Math.max(0, Math.min(maxLeft, maxRight) - height[i]);
            if (maxLeft < height[i]) {
                maxLeft = height[i];
            }
        }


        return result;
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();

        int head = 0, tail = len - 1;

        while (head < tail) {
            boolean headValid = (s.charAt(head) >= 'a' && s.charAt(head) <= 'z')
                    || (s.charAt(head) >= 'A' && s.charAt(head) <= 'Z')
                    || (s.charAt(head) >= '0' && s.charAt(head) <= '9');
            boolean tailValid = (s.charAt(tail) >= 'a' && s.charAt(tail) <= 'z')
                    || (s.charAt(tail) >= 'A' && s.charAt(tail) <= 'Z')
                    || (s.charAt(tail) >= '0' && s.charAt(tail) <= '9');
            if (!headValid) {
                head += 1;
                continue;
            }
            if (!tailValid) {
                tail -= 1;
                continue;
            }
            if (s.charAt(head) - s.charAt(tail) == 0 || s.charAt(head) + 32 == s.charAt(tail) ||
                    s.charAt(head) - 32 == s.charAt(tail)) {
                head += 1;
                tail -= 1;
            } else {
                return false;
            }

        }
        return true;
    }




    public static void main(String[] args) {
        WaterTrap ob = new WaterTrap();
        String s = "dvdf";
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int currentCount = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer index = map.get(ch);
            if(index != null && index > last) {
                maxCount = Math.max(currentCount, maxCount);
                currentCount = i - Math.max(index, last);
                map.put(ch, i);
                last = index;
            } else{
                currentCount += 1;
                map.put(ch, i);
            }
        }
        System.out.println(Math.max(maxCount, currentCount));
    }
}

