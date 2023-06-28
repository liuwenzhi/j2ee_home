package lkhwtk.leetcode367;

/**
 * 直接使用Math的sqrt函数来求解
 */
public class Solution1 {
    public boolean isPerfectSquare(int num) {
        String s = Math.sqrt(num)+"";
        if("0".equals(s.split("\\.")[1])){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        //System.out.println(Math.sqrt(4));
        Solution1 solution1 = new Solution1();
        solution1.isPerfectSquare(4);
    }
}
