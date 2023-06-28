package lkhwtk.leetcode842;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考题解：官方
 * 官方题解和本人题解一个思路，但是做了优化，效率更高
 */
public class Solution1 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, num, num.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String num, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + num.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, num, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
