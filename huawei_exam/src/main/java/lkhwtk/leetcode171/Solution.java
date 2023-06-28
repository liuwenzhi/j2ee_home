package lkhwtk.leetcode171;

/**
 * 171. Excel 表列序号
 * 题解参考：画解算法：171. Excel表列序号
 * 本题可以模拟成一个26位数计算
 * 本题和168题类似
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for(int i=0;i<columnTitle.length();i++){
            char c = columnTitle.charAt(i);
            sum = sum*26+(int)c-'A'+1;
        }
        return sum;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("AB"));
    }
}
