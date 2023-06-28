package lkhwtk.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 三数之和不在华为机试范围内，三数之和是固定一个数字找两个，四数之和可以固定两个找两个
 * 这种思路能把时间维度降低一个维度，3重循环搞定问题
 * 参考题解：算法思维养成记【双指针和排序去重】- 四数之和 这个视频说得不错，官方说和和这个类似
 * 注意：本题的去重方式，都是基于排序的，思路很巧妙
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //长度小于4，直接返回
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // O(n^3)
        for (int i = 0; i < nums.length - 3; i++) {
            //忽略后面与前面重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //忽略后面与前面重复的元素
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //先固定两个值
                int partSum = nums[i] + nums[j];
                //从固定的第二个值之后第一个元素开始往后找到最后一个元素，做加法计算
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = partSum + nums[left] + nums[right];
                    if (sum > target) {
                        //大了，右指针往前移
                        right--;
                    } else if (sum < target) {
                        //小了，左指针往后移
                        left++;
                    } else {
                        //累加结果满足条件则添加到结果列表中
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                        //去重代码的等价代码
                        /*while (left < right) {
                            //第一步去重，left走一步，判断和前边的是否相等，不等就跳出while，经过排序的数组这么去重
                            left++;
                            if (nums[left - 1] != nums[left]) break;
                        }
                        while (left < right) {
                            ////第一步去重，right走一步，判断和后边的是否相等，不等就跳出while，经过排序的数组这么去重
                            right--;
                            if (nums[right + 1] != nums[right]) break;
                        }*/
                    }
                }
            }
        }
        return res;
    }
}
