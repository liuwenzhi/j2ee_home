package lkhwtk.leetcode1160;

/**
 * 注意提示信息：所有字符串中都仅包含小写英文字母
 * 用字符数组替换Map，效率提升一大截
 */
public class Solution1 {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for(String s:words){
            int[] temp = new int[26];
            //借助于一个hashmap，存储chars中每一个字符出现的次数
            for(int i=0;i<chars.length();i++){
                temp[chars.charAt(i)-'a']++;
            }
            boolean flag = true;
            for(int i=0;i<s.length();i++){
                //temp数组中不包含words数组中当前字母中的字符情况
                if(temp[s.charAt(i)-'a']==0){
                    flag = false;
                    break;
                }else{
                    temp[s.charAt(i)-'a']--;
                }
            }
            if(flag){
                result+=s.length();
            }
        }
        return result;
    }
}
