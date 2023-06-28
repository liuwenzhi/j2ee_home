package lkhwtk.leetcode771;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int numJewelsInStones(String jewels, String stones) {
        int length1 = jewels.length();
        int length2 = stones.length();
        int result = 0;
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(jewels.charAt(i)==stones.charAt(j)){
                    result++;
                }
            }
        }
        return result;
    }
}
