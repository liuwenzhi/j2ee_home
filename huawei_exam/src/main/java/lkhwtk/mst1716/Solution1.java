package lkhwtk.mst1716;

/**
 * 对Solution的优化，不使用二维数组，用变量替代
 */
public class Solution1 {
    public int massage(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        //nums[0]不选择的初始值
        int pre0 = 0;
        //nums[0]选择的初始值
        int pre1 = nums[0];
        int dp0 = 0,dp1 = nums[0];
        for(int i=1;i<nums.length;i++){
            //当前nums[i]不选择，则可以从前一个选择和前一个不选择的状态转移过来
            dp0 = Math.max(pre0,pre1);
            //当前nums[i]选择，则只能从前一个不选择转移过来
            dp1 = nums[i]+pre0;
            pre0 = dp0;
            pre1 = dp1;
        }
        return dp0>dp1?dp0:dp1;

    }
}
