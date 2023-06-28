package lkhwtk.leetcode275;

/**
 * 275. H 指数 II
 * 个人思路：找到第一个引用次数大于等于剩余元素数的位置
 * 本题就是把题意读明白就好了，二分查找也是基于这个基础思路，提高了查找效率
 */
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        for(int i=0;i<length;i++){
            //h是剩余元素数量
            int h = length - i;
            //注意：本题是至少引用h次，找到第一个引用次数大于等于剩余文献数量的位置
            if(citations[i]>=h){
                return h;
            }
        }
        //入参只有一个0的时候返回0
        return 0;
    }

    public static void main(String[] args){
        int[] citations = {100};
        Solution solution = new Solution();
        System.out.println(solution.hIndex(citations));
    }
}
