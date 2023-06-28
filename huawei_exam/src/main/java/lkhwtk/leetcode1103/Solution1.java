package lkhwtk.leetcode1103;

/**
 * 思路和Solution一致，比对下哪个效率更高一点
 * 基本一致，没有明显变化
 */
public class Solution1 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] children = new int[num_people];
        int i = 0;
        while(candies!=0){
            //每次自增i+1和candies的最小值
            children[i%num_people]+=Math.min(i+1,candies);
            candies -= Math.min(i+1,candies);
            i++;
        }
        return children;
    }
}
