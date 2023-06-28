package lkhwtk.leetcode55;

/**
 * 55. 跳跃游戏
 * 思路参考：跳跃游戏 官方
 * 【跳跃游戏】别想那么多，就挨着跳吧
 * 和45题对比下
 * 解题思路：
 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
 * 如果可以一直跳到最后，就成功了
 */
public class Solution {
    public boolean canJump(int[] nums) {
        //k保存的是一个最大距离值，因为nums中都是非负整数，所以初始化k为0，没有初始化为整形最小值
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            //遍历的位置，最大达到长度不能达到，返回false
            if (i > k) {
                return false;
            }
            //2021年8月25日补充if判断，时间减少1ms，效率提升将近一倍
            if(i+nums[i]>=nums.length-1){
                return true;
            }
            //i+nums[i]代表从当前位置开始能达到的最大距离。k代表从开始位置到当前位置，往后总共能到达的最大距离
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        //int[] a = {2,3,1,1,4};
        int[] a = {3,2,1,0,4};
        solution.canJump(a);
    }
}
