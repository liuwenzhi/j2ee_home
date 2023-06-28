package lkhwtk.leetcode152;

/**
 * 152. 乘积最大子数组
 * 参考题解：官方
 * 核心思路：建立一个乘积最大子数组和一个乘积最小子数组，分别代表截止元素i为止，最大的连续子数组乘积和最小的连续子数组乘积，因为入参可正可负，
 * 所以最小的乘积值很可能在下一次循环中*当前元素变成最大的值，而之前最大的值在当前循环中变成最小的值，另外还要考虑到，子数组的开始位置可能
 * 不在当前位置元素之前，可能是从当前位置元素开始，所以每次循环比较要和当前元素再单独比较一下
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        //初始化值非常重要，没有这一步，后边什么也推不出来
        maxF[0] = nums[0];
        minF[0] = nums[0];
        //官方原始代码按照如下给出，没有太大意义，因为实际是需要一个初始化的值，但是这么做的好处能增加空间效率
        /*System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);*/
        //循环中每次比较maxF[i-1]*nums[i],minF[i-1]*nums[i],nums[i]
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        //上边动态规划过程只是统计完了，截止到每一个位置，最大的连续子数组乘积，接下来还有从maxF中找出最大的，这一步不能拉下。
        for (int i = 0; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {2,3,-2,4};
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
    }
}
