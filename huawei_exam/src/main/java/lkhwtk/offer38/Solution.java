package lkhwtk.offer38;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 38. 字符串的排列
 * 本题和面试题0807类似，不同点在于本题原始字符串中可能存在重复的字母
 * 用set替换list进行去重
 */
public class Solution {

    /**结果数组，初始化HashSet用这种方式，比用Set = HashSet()的方式节省时间*/
    ArrayList<String> res = new ArrayList<>();
    //HashSet<String> set = new HashSet<>();
    /**访问标记，1代表已访问，0代表未访问，本题中会存在01反复的替换*/
    int[] visited;
    public String[] permutation(String s) {
        visited = new int[s.length()];
        StringBuilder stringBuilder = new StringBuilder();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        for(int i=0;i<c.length;i++){
            stringBuilder.append(c[i]);
        }
        backTrack(stringBuilder.toString(),new StringBuilder());
        //list列表转成String数组
        return res.toArray(new String[res.size()]);
    }

    /**
     * @param S 原始字符串
     * @param stringBuilder 缓存字符串
     */
    private void backTrack(String S,StringBuilder stringBuilder){
        //System.out.println(stringBuilder.toString());
        //递归方法出口，StringBuilder可以直接计算length，不用转字符串
        if(stringBuilder.length()==S.length()){
            res.add(stringBuilder.toString());
            return;
        }
        //for循环，每次循环，分别统计以第i的元素开头的排列信息
        for(int i=0;i<S.length();i++){
            //采用leetcode47题去重的思路，先把S字符串按照字母大小排好序，然后在递归的时候，判断当前字符是否等于前一个字符，
            // 如果等于，那么必须在前一个字符已经使用的情况下，才能再拼接这个到路径中，这么优化之后时间复杂度得到很好提升
            //面试题0808没有做排序，直接使用这个条件陪Set集合就让时间复杂度达到最好
            if (visited[i] == 1||(i>0&&S.charAt(i)==S.charAt(i-1)&&visited[i-1]==0)) {
                //剪枝
                continue;
            }
            char c = S.charAt(i);
            visited[i] = 1;
            stringBuilder.append(c);
            backTrack(S,stringBuilder);
            // 撤销选择
            visited[i] = 0;
            //撤销选择之后需要删除掉sb的最后一个元素，这个非常重要
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args){
        /*KthLargest solution = new KthLargest();
        solution.permutation("abc");*/

        String s = "bdac";
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<c.length;i++){
            stringBuilder.append(c[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
