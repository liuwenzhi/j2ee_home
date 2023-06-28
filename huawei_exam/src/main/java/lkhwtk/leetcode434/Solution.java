package lkhwtk.leetcode434;

/**
 * 434. 字符串中的单词数
 */
public class Solution {
    public int countSegments(String s) {
        if("".equals(s.trim())){
            return 0;
        }
        return s.trim().split("\\s+").length;
    }

    public static void main(String[] args){
        /*KthLargest solution = new KthLargest();
        System.out.println(solution.countSegments("    foo    bar"));*/
        String[] a = "    foo    bar".split("\\s+");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
