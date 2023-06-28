package lkhwtk.leetcode1103;

/**
 * 1103. 分糖果 II
 * 个人思路：直接一趟for循环，把children数组的遍历放到遍历candies的循环中，
 * 用一个i自增和求余的方式实现对children数组的循环遍历
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] children = new int[num_people];
        int i = 0;
        while(candies>0){
            //每次自增i+1和candies的最小值
            children[i%num_people]+=Math.min(i+1,candies);
            candies -= (i+1);
            i++;
        }
        return children;
    }
}
