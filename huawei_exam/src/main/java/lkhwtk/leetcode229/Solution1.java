package lkhwtk.leetcode229;

import java.util.ArrayList;
import java.util.List;
/**
 * 参考题解：官方
 * 优化的摩尔投票法，重点参考下图示相关内容，文字说明有歧义的地方很多
 * 第二个视频下边，归纳总结说得没问题
 */
public class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        //初始化两个候选人candidate，和他们的计票，初始化的两个候选人都是nums[0]，在抵消的流程中会把里边内容替换掉
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        //摩尔投票法，分为两个阶段：抵消阶段和计数阶段
        //抵消阶段，注意抵消的设计流程：先要判断两个候选人中是否有匹配的，没有匹配的，然后候选人数量是0，再进行替换，
        for (int num : nums) {
            //投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人抵消
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人抵消
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }
            //上边if条件都不满足的情况下，说明当前遍历到的不是两个候选人，同时两个候选人的票数都大于0
            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3，在数组中统计出这两个候选人的票数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num) count1++;
            else if (cand2 == num) count2++;
        }

        //判断候选人的票数是否大于总数的1/3
        if (count1 > nums.length / 3) res.add(cand1);
        if (count2 > nums.length / 3) res.add(cand2);

        return res;

    }
}
