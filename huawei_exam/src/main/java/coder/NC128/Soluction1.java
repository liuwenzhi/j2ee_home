package coder.NC128;

/**
 * 思路：以 3 1 2 5 2 4 为例
 * 从左向右扫描，遇到比第一个数大的则构成一个桶，计算盛多少水
 * 然后再从右向左扫描一遍
 */
public class Soluction1 {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int low = 0;
        long sum = 0;
        long tmp = 0;
        //从左向右
        for (int i = 0; i < arr.length; i++) {
            if (arr[low] > arr[i]) {
                tmp = tmp + arr[low] - arr[i];
            }
            if (arr[low] <= arr[i]) {
                sum = sum + tmp;
                tmp = 0;
                low = i;
            }
        }
        low = arr.length-1;
        tmp = 0;
        //从右向左
        for (int j = arr.length-1; j >= 0; j--) {
            if (arr[low] > arr[j]) {
                tmp = tmp + arr[low] - arr[j];
            }
            //注意这里不能再 <=，否则可能会重复计算等于的情况
            if (arr[low] < arr[j]) {
                sum = sum + tmp;
                tmp = 0;
                low = j;
            }
        }
        return sum;
    }
}
