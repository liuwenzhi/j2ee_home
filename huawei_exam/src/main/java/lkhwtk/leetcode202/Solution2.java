package lkhwtk.leetcode202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 纯数学思路，找到重复值链，然后进行比对判断
 */
public class Solution2 {
    /**注意这种hashset的初始化方式*/
    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

}
