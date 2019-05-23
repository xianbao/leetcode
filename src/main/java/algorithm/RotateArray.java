package algorithm;

/**Given an array, rotate the array to the right by k steps, where k is non-negative..
 * 旋转一维数组
 * */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        // 往后挪k个位置
        if (nums.length == 0 || k % nums.length == 0) return;
        k = k % nums.length;
        int value;
        int temp;
        for (int i = 0; i < k; i++) {
            value = nums[0];
            temp = nums[0];
            for (int index = 1; index < nums.length; index++) {
                temp = nums[index];
                nums[index] = value;
                value = temp;
            }
            nums[0] = temp;
        }
    }


    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        // 1,2,3,4,5,6,7
        // 5,6,7,1,2,3,4
        // 5,6,1,2,3,4
        test.rotate(new int[]{1,2,3,4,5,6}, 2);
    }
}
