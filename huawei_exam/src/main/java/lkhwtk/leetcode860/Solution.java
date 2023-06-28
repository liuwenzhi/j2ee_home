package lkhwtk.leetcode860;

/**
 * 860. 柠檬水找零
 * 参考题解：官方
 * 纯贪心思路，对Solution是一个很好的优化，找零20的贪心思路中，官方给出的解释是
 * 10和5的组合或者5、5、5的组合，然后先选择10和5的组合，主要是5用的场景比10多
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                //20的情况
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}
