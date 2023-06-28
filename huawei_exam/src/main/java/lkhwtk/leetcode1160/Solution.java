package lkhwtk.leetcode1160;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 * 注意本题的坑点：遍历每个单词，chars中的字母只能用一次
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        for(String s:words){
            Map<Character,Integer> map = new HashMap<>();
            //借助于一个hashmap，存储chars中每一个字符出现的次数
            for(int i=0;i<chars.length();i++){
                map.put(chars.charAt(i),map.getOrDefault(chars.charAt(i),0)+1);
            }
            boolean flag = true;
            for(int i=0;i<s.length();i++){
                if(!map.containsKey(s.charAt(i))){
                    //map中不包含这个字符key，则直接置flag为false
                    flag = false;
                    break;
                }else{
                    //map中包含了这个key，则要么value-1，要么删除这个key
                    if(map.get(s.charAt(i))>1){
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    }else{
                        map.remove(s.charAt(i));
                    }
                }
            }
            if(flag){
                result+=s.length();
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(chars.replace("a",""));

    }
}
