package lkhwtk.offer11;

/**
 * 参考题解：官方
 * 二分查找思路非常巧妙，比较枢轴元素和最末端元素，分三种情况来讨论，具体看题解
 */
public class Solution1 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

}
