package lkhwtk.leetcode961;

/**
 * 用整形数组代替Map，效率提升许多
 */
public class Solution2 {
    public int repeatedNTimes(int[] nums) {
        //题解中：0 <= A[i] < 10000
        int[] cache = new int[10000];
        int n = nums.length/2;
        for(int i=0;i<nums.length;i++){
            cache[nums[i]]++;
        }
        for(int i=0;i<cache.length;i++){
            if(cache[i] == n){
                return i;
            }
        }
        return 0;
    }
}
