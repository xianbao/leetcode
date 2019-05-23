package algorithm;

/**Given an unsorted integer array, find the smallest missing positive integer.
 * 解法：由于是查找缺失最小得正整数，所以最后得结果是在[1,nums.length+1]中
 * 移动nums中的元素，使其nums[i] - 1的值存放在i处,最后循环判断nums中元素即可
 * .*/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if ((nums[index] - 1) != index) return index + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] nums = {1,-1,-2};
        int result = test.firstMissingPositive(nums);
        System.out.println(result);
    }
}
