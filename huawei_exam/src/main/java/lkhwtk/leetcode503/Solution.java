package lkhwtk.leetcode503;

/**
 * 503. 下一个更大元素 II
 * 个人思路：时间效率偏低
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        //外层for循环遍历nums中的元素，找最小值
        for(int i=0;i<length;i++){
            boolean flag = false;
            //从i+1的位置开始找，如果i是最后一个位置，则从最开始的位置开始找，统计标记为：(i+1)%length
            int j=(i+1)%length;
            while(j!=i){
                if(nums[j]>nums[i]){
                    flag = true;
                    result[i] = nums[j];
                    //找到就直接跳出循环
                    break;
                }
                j = (j+1)%length;
            }
            if(!flag){
                result[i] = -1;
            }
        }
        return result;
    }
}
