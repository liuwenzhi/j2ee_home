package lkhwtk.leetcode646;

import java.util.Arrays;

/**
 * 646. 最长数对链
 * 思路：官方，贪心算法
 * [[1,2], [2,3], [3,4]]
 * {{1,2},{7,8},{4,5}};
 * 本题按照[1]排序，能够解决掉个人思路在Solution中的问题，题干中有一个细节注意下：[0]一定比[1]小，
 * 对[1]进行排序之后，Solution中的思路的问题就行搞定，这个很神奇。参考下452题题解
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        //按照v1进行升序排序
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) {
            if (cur < pair[0]) {
                //每次Cur需要更新的最新的一个数对结尾位置
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] pairs = {{1,2},{2,3},{3,4}};
        solution.findLongestChain(pairs);
    }
}
