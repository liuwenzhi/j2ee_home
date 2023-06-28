package lkhwtk.leetcode1094;

/**
 * 1094. 拼车
 * 参考题解：两个思路，都很简单(超过100%)，构造负载/容量变化数组，检查负载即可
 * 思路二：对思路一进行一个简单的优化，创建一个容量数组，只对上下车的地点进行统计，上车就减掉具体乘客容量，
 * 下车就增加具体乘客容量，然后再用一个for循环根据入参容量对统计的容量进行累加，如果一旦出现小于0的情况，超载返回
 */
public class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChanges = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            capacityChanges[trips[i][1]] -= trips[i][0];
            capacityChanges[trips[i][2]] += trips[i][0];
        }

        for (int i = 0;i < capacityChanges.length;i++) {
            capacity += capacityChanges[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
