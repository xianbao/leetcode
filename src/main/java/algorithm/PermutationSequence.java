package algorithm;

import java.util.ArrayList;
import java.util.List;

/**The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * 有序全排列，返回指定第K个排列
 .*/
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            sb.append(i);
        }
        int length = list.size();
        if (count == k) return sb.toString();
        else sb.delete(0, length);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int index = length - 1; index > 0; index--) {
                if (list.get(index) > list.get(index - 1)) {
                    flag = true;
                    for (int start = length - 1; start > index - 1; start--) {
                        if (list.get(start) > list.get(index - 1)) {
                            count += 1;
                            int temp = list.get(index - 1);
                            list.set(index - 1, list.get(start));
                            list.set(start, temp);
                            // 对index后面的元素逆序
                            int middle = index - 1 + (length - index) / 2;
                            for (int i = index, j = length - 1; i <= middle; i++, j--) {
                                temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                            if (k == count) {
                                for (int i = 1; i <= length; i++) {
                                    sb.append(list.get(i - 1));
                                }
                                return sb.toString();
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return "";
    }


    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(4, 9));
    }
}
