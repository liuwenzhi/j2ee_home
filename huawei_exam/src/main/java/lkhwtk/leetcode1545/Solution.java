package lkhwtk.leetcode1545;

/**
 * 1545. 找出第 N 个二进制字符串中的第 K 位
 * 个人递归思路
 */
public class Solution {
    public char findKthBit(int n, int k) {
        String s = build(n);
        return s.charAt(k-1);
    }

    /**
     * 通过递归方法构建题目要求的字符串
     */
    private String build(int n){
        //递归方法出口
        if(n==1){
            return "0";
        }else {
            String last = build(n - 1);
            String result = last + "1" + reverseInvert(last);
            return result;
        }
    }

    /**
     * 将一个01组成的字符串取逆之后取反
     */
    private String reverseInvert(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                stringBuilder.append('0');
            }else{
                stringBuilder.append('1');
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        /*System.out.println(solution.build(1));
        System.out.println(solution.build(2));
        System.out.println(solution.build(3));
        System.out.println(solution.build(4));*/
        //System.out.println(solution.findKthBit(4,11));
        String s = "0101010101";
        System.out.println();
    }


}
