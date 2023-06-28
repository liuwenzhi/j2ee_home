package lkhwtk.leetcode325;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于滑动窗口思路，参考题解：滑动窗口
 * 本题思路和Solution思路很像
 */
public class Solution1 {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        //key：累加值，value：数组元素下标
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        //从nums数组的头到尾，统计每一个元素和之前元素的累加和
        for (int i = 0; i <len ; i++) {
            sum = sum + nums[i];
            //相当于窗口右移一位
            if(sum == k){
                //有可能就是答案，注意：要返回子数组长度，i是从0开始，这里计算ans需要+1
                ans = i+1;
            }
            if(map.containsKey(sum - k)){
                //后边i-map.get(sum-k)，下标-下标，正好是子数组长度
                ans = Math.max(ans,i-map.get(sum-k));
            }
            //加一个不包含sum的条件，后面再遇到的不用加进去，因为长度肯定大，我们要比较小的，因为这个东西是要被减去的。
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return ans;
    }
}
