package lkhwtk.leetcode12;

/**
 * 12. 整数转罗马数字
 * 参考题解：贪心算法（Java）
 * 本题精选的贪心算法思路不错，设计精妙
 * 本题直直接记住贪心法的结论
 */
public class Solution {
    public String intToRoman(int num) {
        //把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        //在原有的基础字母之外，再加入4000以内的需要做减法的数值，剩余其他的都是用贪心做加法
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            //nums数组低位实际是枚举数字大的值开始判断，入参num是否大于nums数组当前值，特别注意：这里是等号
            //内层循环也可能多次进入，比如计算13，减去10之后，最后index=12,3多次和1比较，最终结果在X（10）之后拼了三个I（1）
            while (num >= nums[index]) {
                //如果num大于当前nums数组中的值，则拼接当前数值对应的罗马文字
                stringBuilder.append(romans[index]);
                //num做减法
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1800));
    }
}
