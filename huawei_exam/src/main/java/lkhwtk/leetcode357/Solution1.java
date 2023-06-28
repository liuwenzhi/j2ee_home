package lkhwtk.leetcode357;

/**
 * 动态规划，核心思路和solution一致
 * 参考思路：Java多解法：回溯 / 动态规划 / 枚举
 */
public class Solution1 {
    /**
     * 本题是一个基于数学规律的题目
     * 1位数字：0~9中各个位不重复的数字个数          10个， 因为是1位数，都不重复
     * 2位数字：10-99中各个位不重复的数组个数        81个，  9*9
     * 3位数字：100-999中各个位不重复的数字个数      648个， 9 * 9 * 8
     * 4位数字：1000-9999中各个位不重复的数字个数    4356个，9 * 9 * 8 * 7
     * ... ...
     * 最后，总数 = 上边统计的各个段的统计值之和
     * 本题中n应该是小于10的，不然10的10次幂超过了int的表示范围
     */
    public int countNumbersWithUniqueDigits(int n) {
        //n=0只有一个数字
        if (n == 0){
            return 1;
        }
        int first = 10, second = 9 * 9;
        int size = Math.min(n, 10);
        for (int i = 2; i <= size; i++) {
            first += second;
            //注意：这里是先计算10-i，然后再和second相乘并赋值给second
            second *= 10 - i;
        }
        return first;
    }
    public static void main(String[] args){
        int i = 4;
        i *= 2+4;
        System.out.println(i);
    }
}
