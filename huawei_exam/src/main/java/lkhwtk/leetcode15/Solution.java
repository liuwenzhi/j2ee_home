package lkhwtk.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 参考题解：排序 + 双指针，逐行解释
 * 可以配合官方视频看下
 * 本题只要把题读懂，梳理好核心思路和边界去重问题，其实真的不难
 * 核心思路：数组排序，固定一个数，找另外两个数
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序，从小到大进行排序，排序之后，如果要三数和为0，则第一个元素必须小于等于0
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            //nums[i]作为每次循环的首元素数字，这个数字必须不能大于0，这样才能保证排序后的数组，能够组成等于0的组合
            if(nums[i] > 0) {
                return lists;
            }
            //首元素之后元素去重，答案中不能包括重复的三元组
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //固定首元素
            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    //比较一遍之后左右指针移动的时候，需要做去重处理
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    //去重后，L和R需要再移动一次，保证和循环前位置上的元素不一致，因为此时保证了L、R和他们的下一个元素不同，但是和while循环之前位置的元素是相同的，需要L和R指向下一个位置
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    //三数和小于0，则左指针移动，让和增大
                    ++L;
                } else {
                    //三数和大于0则右指针移动，让整体和变小
                    --R;
                }
            }
        }
        return lists;
    }
}
