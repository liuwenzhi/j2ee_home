package lkhwtk.leetcode875;

/**
 * 875. 爱吃香蕉的珂珂
 * 参考题解：二分查找定位速度（最大值最小化问题，Java）
 * 核心思路：二分查找，最小速度是每小时1根，记录为1，最大速度是最大一堆香蕉的数量（题目限制了一个小时只能吃一堆），
 * 通过二分查找的方式，找到最小速度和最大速度之间，一个能在规定时间H小时内，吃完香蕉的最小速度
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        //设置速度最小值为1（即每小时1根），耗时最长
        int left = 1;
        //速度最大的时候，耗时最短
        int right = maxVal;
        //从最小速度到最大速度去找一个折中的速度，保证正好耗时<=H
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //按照本题中二分算法代码，最终left和right走到了同一个位置，返回left和right都可以
        return left;
    }

    /**
     * 计算按照speed速度吃掉全部香蕉所要耗费耗费的时间，采用向上取整的方式，即：就算多了0.1小时也算是多1个小时
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写，例如：10/3=3,（10+3-1）/3=4
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }
}
