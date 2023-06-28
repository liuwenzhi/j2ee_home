package lkhwtk.leetcode1151;

/**
 * 1151. 最少交换次数来组合所有的 1
 * 参考思路：最少交换次数来组合所有的 1 官方
 * 核心为滑动窗口，注意边界，滑动窗口中元素为前闭后开，头元素包括，尾元素不包括
 * 本题官方题解中，对窗口的解释非常不错，后边重点参考下。
 * 核心思路：找到数组中1的个数num1，定义一个宽度为count的窗口，然后从头滑动到尾，看看在哪一次滑动中，1的次数最多，记为max
 * num1-max即为最小的移动数量，本题属于标准的滑动窗口题目。
 */
public class Solution {
    public int minSwaps(int[] data) {
        int num1 = 0;
        //先统计出data数组中1的个数
        for(int i=0;i<data.length;i++){
            if(data[i]==1){
                num1++;
            }
        }
        //定义一个滑动窗口，窗口长度为num1（即data数组中1的个数），然后通过for循环统计一个初始的1的数量，
        //count1，count1就是初始窗口里边的1的数量
        int count1 = 0;
        for(int i=0;i<num1;i++){
            count1+=data[i];
        }
        //max代表窗口中最大的1的个数
        int max = count1;
        for(int i=num1;i<data.length;i++){
            //每次统计count1，可能增加，可能减少，data[i]是当前窗口第一个元素，data[i-num1]是上一个窗口第一个元素
            count1 += (data[i] -data[i-num1]);
            max = Math.max(max,count1);
        }
        //最后拿到一个窗口中最大的1的数量max，用1的总量减去最大的数量，就是最小的移动数量
        return num1 - max;
    }
}
