package lkhwtk.offer45;

import java.util.Arrays;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 参考题解：官方，核心思路：用String类内置的compareTo方法进行字符串比较
 * 底层实现原理每太看懂，大体思路是根据字符串中每一个字符的编码进行比对，源
 * 码中的注释可以仔细读一下。先把这个思路记录下，太方便了
 * 对比下179题求最大数，本题在说明中给出了：
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 本题不用单独处理0开头的情况，179题由于是在相同的非负数组中求最大数，0开头只可能一种情况，全是0，需要单独处理下
 */
public class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        //将原始整形数组转成字符串数组
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //通过String类内置的比较方法进行比对，设置最小数拼接，如果是拼接最大数就是：Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args){
        //定义两个字符串直接用>比较比较不了
        /*String a = "21";
        String b = "3";*/
        Solution solution = new Solution();
        int[] nums = {10,2};
        System.out.println(solution.minNumber(nums));
    }
}
