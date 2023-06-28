package lkhwtk.leetcode1122;

/**
 * 1122. 数组的相对排序
 * 参考题解：明确比较方式后，想怎么排就怎么排：计数排序、lambda表达式、快速、归并、希尔
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //依据题意，arr1和arr2的长度都不超过1000，定义一个count数组，长度为1001
        int[] count = new int[1001];
        //将 arr1 中的数记录下来，注意arr1中的数字可能有重复的，将arr1中的元素作为count数组的下标，进行对应位置值的累加
        for (int num1 : arr1) {
            count[num1]++;
        }
        //借助count数组的内容，将arr2 中的数添加到arr1中
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        //在arr1中安排剩余的数字，count数组的下标直接起到的排序的作用
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }
}
