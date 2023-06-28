package lkhwtk.leetcode1438;

import java.util.TreeMap;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 参考题解：官方，本题需要借助于底层工具来做，主要是在窗口内最大值和最小值比较的问题
 * TreeMap的验证参考main方法
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //java开发滑动窗口算法，最常用的求出窗口内最大值和最小值的方法是用TreeMap数据结构
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            //right从0开始循环，每次都把最新一个元素加入到排序集合map中，key是实际数组中数字，值是该数字在数组中出现次数
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            //如果窗口中元素差值最大值大于limit，就把最左边元素数量-1，最左边元素通过left来找
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                //如果最左边元素==0了，那么就在map中删除掉这个元素
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            //每次重新统计窗口大小
            ret = Math.max(ret, right - left + 1);
            //每次循环结束right右移一位，left是否移动看实际情况
            right++;
        }
        return ret;
    }

    public static void main(String[] args){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,0);
        map.put(2,2);
        map.put(1,1);
        //firstKey是最小key
        System.out.println(map.firstKey());
        //lastKey是最大key
        System.out.println(map.lastKey());
    }
}
