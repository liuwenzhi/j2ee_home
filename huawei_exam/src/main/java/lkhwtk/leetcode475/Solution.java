package lkhwtk.leetcode475;

import java.util.Arrays;

/**
 * 475. 供暖器
 * 个人思路：暴力法。
 * 对于每一个房子，找到全部供暖器和和它的距离，保存到一个数组中（数组长度为供暖器数组大小），然后
 * 从这个数组中找到一个最小距离。在得到全部单个房子最小距离数组之后，再从这个数组中找到一个最大的
 * 距离。代码实现对这一思路进行优化，临时数组均采用临时变量的方式。
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        //个人题解加上排序能节省将近一半时间，但是和Solution1中内层循环使用折半查找效率仍然差很多。
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            //minDist作为临时变量保存每一个房子到供暖器的最短距离
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                minDist = Math.min(minDist,Math.abs(heaters[j] - houses[i]));
            }
            //在每一轮循环的最后，从minDist中找到最大的距离作为半径
            radius = Math.max(radius,minDist);
        }
        return radius;
    }
}
