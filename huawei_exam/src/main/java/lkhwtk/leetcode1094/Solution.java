package lkhwtk.leetcode1094;

/**
 * 1094. 拼车
 * 参考题解：两个思路，都很简单(超过100%)，构造负载/容量变化数组，检查负载即可
 * 思路一：构造站点负载数组，统计到每一个站点时负载信息，非常聪明的一个思路，效率稍低，但是很巧妙的避免了排序等内容
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //构造一个负载数组，0 <= trips[i][1] < trips[i][2] <= 1000，这个负载数组的长度设定为大于1000即可
        int[] allTrip = new int[1001];
        //外层循环遍历行程表中每一行元素，内层循环去统计起点和终点之间各个点的乘客个数，依据题意：起点和终点都是距离初始位置的实际距离，
        //那么可以假设每一个单位距离上就有一个距离点，然后直接统计出这些距离点上的乘客数，一旦超过数量，就是超载，不满足条件
        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                allTrip[j] += trips[i][0];
                if (allTrip[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }
}
