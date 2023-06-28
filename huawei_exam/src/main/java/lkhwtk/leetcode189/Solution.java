package lkhwtk.leetcode189;

/**
 * 189. 旋转数组
 * 直接这么搞会超时
 * 用例通过数：36/37
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        for(int i=0;i<k;i++){
            //用一个缓存变量存储最后一个元素
            int temp = nums[len-1];
            for(int j=len-1;j>0;j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }
}
