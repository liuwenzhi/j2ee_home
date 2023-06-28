package lkhwtk.leetcode139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 参考题解：官方，
 *           动态规划+记忆化回溯 逐行解释 python3
 * 用官方代码配合python这个文字说明来看
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //基于list列表创建一个set集合，注意这种实现方式，2021年9月26日，二轮刷题去掉，直接用wordDict判断即可，能节省1ms
        //Set<String> wordDictSet = new HashSet(wordDict);
        //动态规划dp数组代表：截止到第i个字母，之前的子串能否匹配，具体匹配方式不管
        boolean[] dp = new boolean[s.length()+1];
        //这一步很重要，算法中后面的计算基于一个开始位置
        dp[0] = true;
        //核心思路，j在前，i在后，dp[j]能匹配，同时j到i的字符串能匹配，则dp[i]=true
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++) {
                //[j,i)这样一个子串能否被字典表示，注意：i从1开始，substring正好计算到第i位，对应的字符串下标是i-1
                //注意：这里是判断dp[j]，对于同一个j，dp数组里边表示的位数比s数组小一位，dp数组中的j对应s数组中j-1
                //即：从0位到j-1位之间，能否用字典中单词表示
                if (dp[j]&&wordDict.contains(s.substring(j, i))){
                    //这里只要找到匹配，就不管后边了，可能有多重匹配方式，比如main函数中
                    //到d这个位置，可能是cat sand，也可能是cats and，到这个位置能表示出来，
                    //接来下就看到下一个位置，前边有没有子串能匹配上
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] agrs){
        Solution solution = new Solution();
        String[] n = {"cats", "dog", "sand", "and", "cat"};
        List<String> list = new ArrayList<>(5);
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        solution.wordBreak("catsandog",list);

    }
}
