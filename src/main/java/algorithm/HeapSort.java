package algorithm;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion
 */
public class HeapSort {
    /**
     * 堆排序
     * */
    public static void heapSort(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int large = index;
        if (left < heapSize && arr[left] < arr[large]) {
            large = left;
        }
        if (right < heapSize && arr[right] < arr[large]) {
            large = right;
        }
        if (large != index) {
            // 交换最大值
            int temp = arr[index];
            arr[index] = arr[large];
            arr[large] = temp;
            heapSort(arr, heapSize, large);
        }
    }
    /**
     * 创建堆
     * */
    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i>=0; i--) {
            heapSort(arr, arr.length, i);
        }
    }
}
