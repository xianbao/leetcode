package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    // hash表计数
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        int n = nums.length % 2 == 0 ? nums.length / 2 : (nums.length + 1) / 2;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= n) return entry.getKey();
        }
        return 0;
    }
    // 摩尔投票
    public int majorityElementByMoore(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) candidate = nums[i];
            if (candidate == nums[i]) count++;
            else count--;
        }
        return candidate;
    }
    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        System.out.println(test.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
