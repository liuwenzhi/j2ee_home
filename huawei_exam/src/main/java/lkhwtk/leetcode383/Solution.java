package lkhwtk.leetcode383;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 个人思路：借助map集合保存magazine上的字符和字符剩余数量，时空效率都不高
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(map.get(c)==null){
                return false;
            }else if(map.get(c)>0){
                map.put(c,map.get(c)-1);
            }else{
                //map.get(c)<=0
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a","b"));
    }
}
