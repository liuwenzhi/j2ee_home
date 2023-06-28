package lkhwtk.leetcode698;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 参考题解：(Java)回溯+剪枝，手把手教会你(2021-5-9)
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //定义数组总和变量sum
        int sum=0;
        //使用元素数组used
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        //注意：这里如果使用：Arrays.stream(nums).sum();这种方式统计和，会慢1到2ms
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        /*如果存在满足条件的分组，则一定有元素总和 sum = k*target，其中target是每个分组的和，如果sum不能整除k，
        则一定不满足条件，nums是一个整数数组，里边任意子集的和一定也是整数，注意条件中nums[i]取值范围(0,10000)*/
        if(sum%k!=0) {
            return false;
        }
        //拿到每个分组的实际的和：target(sum/k)，如果nums中最大值大于target，则一定不满足条件，nums[i]取值都是正整数，肯定有分组不满足条件
        int target=sum/k;
        if(nums[nums.length-1]>target) {
            return false;
        }
        //判断nums数组中每一个元素都大于target，这个没有实际时间效率影响
        /*for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]>target){
                return false;
            }
        }*/
        //题目说明中k>=1，如果等于1，肯定也是满足条件
        if(k==1){
            return true;
        }
        return dfs(nums,nums.length-1,target,0,k,used);
    }

    public static boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
    {
        //剪枝1，在递归中，如果k等于1了，则肯定满足条件，在主方法中已经确认了target*k=sum，在找到其他k-1个元素之后，剩下的元素肯定满足条件
        if(k==1) {
            return true;
        }
        //找到了一个组合,还有k-1个，注意：这里的k指的是递归过程中传过来的k值，不是入参的k，重新开始找需要从数组头开始（实际是尾巴，从大到小找），sum=0开始
        //去遍历哪些没有被used的元素
        if(curSum==target) {
            return dfs(nums, nums.length - 1, target, 0, k - 1, used);
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
            if(curSum+nums[i]==target) {
                return true;
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
