package lkhwtk.leetcode763;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 参考题解：官方
 * 本题也是一个思路比较固定的逻辑算法
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        //last数组记录s字符串中每一个字母最后一次出现的位置
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            //在遍历s的过程中，找到出现字母的结束位置，每次更新这个最大位置和end，到后边如果得到了i==end的情况，就记录一个片段
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }
}
