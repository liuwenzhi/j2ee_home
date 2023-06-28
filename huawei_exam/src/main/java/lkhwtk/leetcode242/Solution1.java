package lkhwtk.leetcode242;

/**
 * 借助字符数字实现，效率比Solution高很多
 */
public class Solution1 {
    public boolean isAnagram(String s, String t) {
        //只有在两个字符串长度相等的情况下可能是异位单词
        if(s.length()==t.length()){
            return isBrother(s,t);
        }
        return false;
    }

    /**
     * 定义一个26位的数组，每一位代表对应的小写字母出现次数，s1中存在的小写字母到这个数组中对应位置进行累加，
     * s2中存在的小写字母到这个数组中对应的位置进行累减，最后判断数组中是否每一个元素都是0
     */
    private boolean isBrother(String s1, String s2){
        int[] cache = new int[26];
        char[] c1 = s1.toCharArray();
        for(int i=0;i<c1.length;i++){
            cache[c1[i]-'a']++;
        }
        char[] c2 = s2.toCharArray();
        for(int i=0;i<c2.length;i++){
            cache[c2[i]-'a']--;
        }
        for(int i=0;i<cache.length;i++){
            if(cache[i]!=0){
                return false;
            }
        }
        return true;
    }
}
