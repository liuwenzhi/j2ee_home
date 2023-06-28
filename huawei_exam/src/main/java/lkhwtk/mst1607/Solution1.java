package lkhwtk.mst1607;

import java.util.Arrays;

/**
 * 这个做法真聪明啊，效率还高，哈哈哈哈哈哈哈哈
 */
public class Solution1 {
    public int maximum(int a, int b) {
        int[] arr = new int[2];
        arr[0] = a;
        arr[1] = b;
        Arrays.sort(arr);
        return arr[1];
    }
}
