package lkhwtk.leetcode976;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * 参考题解：三角形的最大周长 官方
 * 本题是贪心算法最直接的应用，本题和611题有一点儿相似，a<b<c，一定有：a+c>b，b+c>a，只需要在算法中搞定a+b>c，所以从贪心的角度来考虑，
 * 一定要找和c最近接的a和b，这一这么想：如果最近的a+b<=c，那么不论a和b再怎么变小，这个式子肯定不满足条件
 */
public class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=length-1;i>=2;i--){
            if(nums[i-1]+nums[i-2]>nums[i]){
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        return 0;
    }
}
