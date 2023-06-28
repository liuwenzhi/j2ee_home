package lkhwtk.leetcode179;

import java.util.Arrays;

/**
 * 179. 最大数
 * 本题思路同offer45，offer45题是计算最小数，本题是计算最大数
 * 注意：本题的用例多了几个跑不完的异常情况，00。
 * 辅助一个知识点说明：String类的substring(start)从start开始截取字符串，一致截取到结尾
 * substring(start,end)，截取[start,end)位字符串，前包含，后不包含，这个方法不能在end
 * 参数这里传length+1，会报出数组下标越界异常，可以传length，截取到结尾最后一个元素。
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        //将原始整形数组转成字符串数组
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //通过String类内置的比较方法进行比对，如果是拼接最大数就是：Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        String result = res.toString();
        //单独处理下以0开头的情况，00,000,0000，因为本题是求解最大数，所以只可能有这几种情况，不会出现0123这种
        //2021年8月30日二轮刷题，优化掉if条件中：&&result.length()>1，没有意义
        if(result.startsWith("0")){
            return "0";
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {101,41425,236};
        System.out.println(solution.largestNumber(a));
    }
}
