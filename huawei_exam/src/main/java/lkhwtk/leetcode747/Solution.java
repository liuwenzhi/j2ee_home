package lkhwtk.leetcode747;

/**
 * 747. 至少是其他数字两倍的最大数
 * 思路：线性扫描，遍历量变，时间复杂度还是O(n)
 * 备注：题目中数组中的元素都是正整数，范围[1,100]
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[max]){
                max = i;
            }
        }
        //第二个for循环注意别和自己比较
        for(int i=0;i<nums.length;i++){
            if(max!=i&&nums[max] < 2*nums[i]){
                return -1;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a = {3,6,1,0};
        int [] b = {1,2,3,4};
        System.out.println(solution.dominantIndex(b));
    }
}
