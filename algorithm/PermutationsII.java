package algorithm;


import java.util.*;

/**
 * @author xiao
 * @date 2019/3/8
 * @descripion
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tempList.add(i);
        }
        Collections.sort(tempList);
        result.add(tempList);
        for (int k = 0; k < nums.length; k++) {

        }

        return result;
    }

    public static void main(String[] args) {
        PermutationsII test = new PermutationsII();
        int[] nums = new int[]{4,3,10,23};
        test.permuteUnique(nums);
    }
}
