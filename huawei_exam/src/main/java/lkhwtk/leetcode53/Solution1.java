package lkhwtk.leetcode53;

/**
 * 贪心思路，如果累加和小于等于0，则舍去，从下一位开始重新累计
 * 核心想法和动态规划一致，使用贪心效率能高出一倍
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += nums[i];
            if(count > result){
                //贪心思路：取区间累计的最大值
                result = count;
            }
            if(count <= 0){
                //贪心核心思路：累加总和小于等于0，就重新开始统计，以下一位为一个新的开始
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        //-2147483648
        System.out.println(Integer.MIN_VALUE);
    }
}
