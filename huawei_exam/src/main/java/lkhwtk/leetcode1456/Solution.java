package lkhwtk.leetcode1456;

/**
 * 1456. 定长子串中元音的最大数目
 * 暴力解法能完成96%的测试用例，最后还是会超时
 */
public class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        for(int i=0;i<s.length()-k+1;i++){
            int num = 0;
            for(int j=i;j<i+k;j++){
                char c = s.charAt(j);
                if(isVowels(c)){
                    num++;
                }
            }
            max = Math.max(num,max);
            if(num==k){
                return max;
            }
        }
        return max;
    }

    /**
     * 判断一个字母是不是元音字母
     */
    private boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("weallloveyou",7));
    }
}
