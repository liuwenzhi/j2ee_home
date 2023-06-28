package lkhwtk.leetcode455;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 本题考查数组遍历，类似之前归并排序的思路，二轮复习时简要过一下即可
 */
public class Solution {
    /**
     * g 是孩子数组，s是饼干数组
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(g[i]<=s[j]){
                result++;
                i++;j++;
            }else{
                j++;
            }
        }
        return result;
    }
}
