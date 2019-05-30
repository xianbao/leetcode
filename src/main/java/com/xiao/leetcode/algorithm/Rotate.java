package com.xiao.leetcode.algorithm;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion ��ά����˳ʱ�뷽����ת90�ȣ���������������ռ�
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        int len = matrix[0].length;
        int temp;
        // ��Χѭ������
        for (int i = 0; i < (len + 1) / 2; i++) {
            // �ƶ�����
            int moveDistance = len - i * 2 - 1;
            int index = i + moveDistance;
            int value;
            for (int j = i; j < len - i - 1; j++) {
                int row = i, col = j;
                temp = matrix[row][col];
                // ����
                row += col + moveDistance - index;
                col = index;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // ����
                col = index - (row + moveDistance - index);
                row = index;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // ����
                row += col - moveDistance - i;
                col = i;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // ����
                col -= row - moveDistance - i;
                row = i;
                matrix[row][col] = temp;
            }
        }
    }
}

