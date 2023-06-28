package lkhwtk.leetcode3;

/**
 * 这么做有问题，能跑完41%的测试用例，"dvdf"这种情况，得到结果偏小，遍历到第二个d的时候，需要从
 * v开始往后走，不是从第二个d开始，个人思路中没有记录位置，实际完成不了。
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||"".equals(s)){
            return 0;
        }
        int maxHistoryLength = 1;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        while(right<s.length()-1){
            right++;
            if(!stringBuilder.toString().contains(s.charAt(right)+"")){
                stringBuilder.append(s.charAt(right));
                if(stringBuilder.toString().length()>maxHistoryLength){
                    maxHistoryLength++;
                }
            }else{
                stringBuilder.setLength(0);
                stringBuilder.append(s.charAt(right));
            }
        }
        return maxHistoryLength;
    }
}
