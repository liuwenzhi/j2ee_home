package lkhwtk.leetcode324;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 参考题解：3ms 99% 先排序再穿插
 * 本题采用了非常巧的一种思路，排序之后，倒叙穿插，本题和280题的不同点在于本题是严格的大于和小于，
 * 按照280题的解法，本题只能跑完一半多一点的用例。
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        //不能写成int[] help = nums,排序后两个数组都改变
        int[] help = nums.clone();
        Arrays.sort(help);
        int N = nums.length;
        //注意：两个for循环的条件都是i < nums.length，原始数列可能是奇数也可能是偶数，for循环中虽然条件是i+=2，但是一定要这么设置条件保证不漏替换
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = help[--N]; //遍历完成后 x 6 x 5 x 4
        }
        //这里如果设置为i<nums.length-1，在main中的测试数据，就会导致漏项没有替换的情况，测试数据a数组是一个长度为奇数的数组
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = help[--N]; //遍历完成后 3 6 2 5 1 4
        }
    }
    public static void main(String[] args){
        int[] a = {1,4,3,4,1,2,1,3,1,3,2,3,3};
        Solution solution = new Solution();
        solution.wiggleSort(a);
        //[3,4,2,4,2,3,1,3,1,3,1,3,3]
        //[3,4,2,4,2,3,1,3,1,3,1,3,1]
    }
}
