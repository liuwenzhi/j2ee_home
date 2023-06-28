package lkhwtk.leetcode11;

/**
 * 参考题解：官方，看下官方视频，双指针法
 * 注意两点：
 * 1、相同情况下两边距离越大越好
 * 2、区域受限于较短的边
 * 双指针法实际是对暴力法的优化，去除一些不必要的计算
 */
public class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        //注意：这里一定是j-i，不是height.length，length求的是元素个数，不是实际空间宽度
        int max = (j-i)*Math.min(height[i],height[j]);
        while(i<j){
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
        }
        return max;
    }
}
