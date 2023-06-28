package lkhwtk.leetcode560;

import java.util.Arrays;

/**
 * 560. 和为K的子数组
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        for(int i=0;i<length;i++){
            int temp = nums[i];
            //可能开始位直接就是k
            if(temp==k){
                result++;
            }
            for(int j=i+1;j<length;j++){
                temp+=nums[j];
                if(temp==k){
                    result++;
                    //等于k的时候不应该跳出，可能后边数字为0或者有正有负还能继续统计
                    //break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {100,1,2,3,4};
        int k = 3;
        System.out.println(solution.subarraySum(a,k));
    }
}
