package lkhwtk.leetcode45;

/**
 * 45. 跳跃游戏 II
 * 参考题解：官方：方法二：正向查找可到达的最大位置
 * 和55题对比下
 */
public class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        /*在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了，访问最后一个元素会增加一次跳跃次数*/
        for(int i = 0; i < nums.length - 1; i++){
            //基于贪心的思路：找下一个位置能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end){
                //遇到边界，就更新边界，并且步数加一，第一步有一个开始的更新，其实这里的代码和题解中的解析并不矛盾，以main方法中测试代码为例：
                //按照题解中的理解，应该是从2到3到最后，这样的两步，按照代码，感觉像是从2到1（下标2），然后再到4，代码中并不是显示的表示从2到3
                //到最后，这样的两步，是在走过3之后，更新边界的时候，step++，注意主要是3这个位置更新maxPosition的影响。end肯定能到最后一个位置，代码这么写就是一个贪心的思路。
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println(solution.jump(nums));
    }
}
