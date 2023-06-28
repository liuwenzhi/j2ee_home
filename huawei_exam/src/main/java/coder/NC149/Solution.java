package coder.NC149;

/**
 * NC149 kmp算法
 * 个人思路：硬来，超时了，能跑完71.4%的测试用例
 */
public class Solution {
    public int kmp (String S, String T) {
        // write code here
        int result = 0;
        int lenS = S.length();
        int lenT = T.length();
        for(int i=0;i<lenT-lenS+1;i++){
            if(S.equals(T.substring(i,i+lenS))){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.kmp("ababab","abababab"));
        System.out.println(solution.kmp("abab","abacabab"));
    }
}
