package lkhwtk.leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 个人思路优化，使用整形数组记录字母出现，不需要排序过程，直接进行字符数组比较
 * 时间效率不高
 */
public class Solution1 {
    public List<Integer> findAnagrams(String s, String p) {
        //记录p的所有字母及其个数
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length()-p.length()+1;i++) {
            for(int j=i;j<i+p.length();j++){
                window[s.charAt(j) - 'a']++;
            }
            if(Arrays.equals(window,need)){
                result.add(i);
            }
            Arrays.fill(window,0);
        }
        return result;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        String s = "cbaebabacd", p = "abc";
        solution.findAnagrams(s,p);
        /*int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(Arrays.equals(a,b));*/
    }
}
