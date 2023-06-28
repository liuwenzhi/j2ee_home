package lkhwtk.leetcode438;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 个人思路：超时了，跑完了56%的测试用例
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length()-p.length()+1;i++) {
            String s1 = s.substring(i,i+p.length());
            if(check(s1,p)){
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 验证子串是否是异位字母
     */
    private boolean check(String s1,String p){
        char[] c1 = s1.toCharArray();
        char[] c2 = p.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        //可以直接用这种方式比较两个一维数组
        Arrays.equals(c1,c2);
        /*for(int i=0;i<c1.length;i++){
            if(c1[i]!=c2[i]){
                return false;
            }
        }*/

        return true;
    }

    public static void main(String[] args){
        /*KthLargest solution = new KthLargest();
        String s = "cbaebabacd", p = "abc";
        solution.findAnagrams(s,p);*/
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(Arrays.equals(a,b));
    }


}
