package lkhwtk.leetcode771;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 * 思路：本题使用暴力解法每遍历一个宝石中的字母，就需要遍历一遍石头中的字母
 * 可以使用哈希集合代替之，能降低判断的时间复杂度，但是经过实际测试这种方式没有Solution1效果好，哈哈
 */
public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int length1 = jewels.length();
        int length2 = stones.length();
        int result = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        for(int i=0;i<length1;i++){
            jewelsSet.add(jewels.charAt(i));
        }
        for(int i=0;i<length2;i++){
            if(jewelsSet.contains(stones.charAt(i))){
                result++;
            }
        }
        return result;
    }
}
