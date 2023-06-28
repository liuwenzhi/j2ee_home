package lkhwtk.leetcode287;

/**
 * 参考题解：287.寻找重复数
 *         配合官方第三种方法理解下这个题解
 * 核心思路是建立一个下标和数组元素映射的方程，形成一个单链表，如果数组中有重复的元素，
 * 那么这个生成的单链表一定存在环，基于142题的思路思路找到环的入口，就是重复的数值
 * 注意题干中的这一点：数组长度为n+1，数组中的元素都在1到n之间
 */
public class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        //根据映射关系，快的走两步
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //重合之后，快的回到开始位置，再和慢的一步一步走一遍，重合点就是单链表环的入口，即数组重复元素
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

}
