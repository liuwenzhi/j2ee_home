package lkhwtk.leetcode416;

import java.util.Arrays;

/**
 * 参考698题使用递归回溯算法，能跑完30%多的测试用例，数据量比较大的时候会超时
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        boolean[] used=new boolean[nums.length];
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0) {
            return false;
        }
        int target=sum/2;
        //数组进行从小到大排序，至少最大的元素不能比target大
        Arrays.sort(nums);
        if(nums[nums.length-1]>target) {
            return false;
        }
        return dfs(nums,nums.length-1,target,0,2,used);
    }

    public static boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
    {
        //剪枝1，在递归中，如果k等于1了，则肯定满足条件，在主方法中已经确认了target*k=sum，在找到其他k-1个元素之后，剩下的元素肯定满足条件
        if(k==1||curSum==target) {
            return true;
        }

        //从大往小遍历，类似贪心的思想，比如：样例中组合【4】要达到5只需要找值为1的元素，而【1】要达到5则要把遇到的2，3，4都试一遍，这里对应题解剪枝4
        //正常如果存在k个数组，那么递归过程中，最外成的for循环执行完就能够找到k个数组
        for(int i=begin;i>=0;i--)
        {
            //使用过的元素就不能再使用了
            if(used[i]) {
                continue;
            }
            //题解剪枝2，这里既是回溯，也是剪枝
            if(curSum+nums[i]>target) {
                continue;
            }
            //在未使用且sums[i]+curSum<=target的情况下，进一步遍历，添加元素nums[i]
            used[i]=true;
            if(dfs(nums,i-1,target,curSum+nums[i],k,used)) {
                //如果添加这个元素后，完成了题目要求，就return true.
                return true;
            }
            //回溯
            used[i]=false;
            //有重复元素进行剪枝，nums[i]不行，nums[i-1]就不进行处理了，对应题解剪枝3
            while(i>0&&nums[i-1]==nums[i]) {
                i--;
            }
        }
        return false;
    }
}
