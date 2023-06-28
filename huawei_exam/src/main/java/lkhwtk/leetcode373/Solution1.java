package lkhwtk.leetcode373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 * 参考题解：查找和最小的K对数字
 * 思路二：堆
 * 这个题解思路相当不容易想，很巧妙，堆排序和堆存储的内容是存在一个关联关系，不是直接用。相对于暴力法来说，
 * 基于nums1和nums2都是排好序的数组，优化了Arrays.sort的性能
 * 备注：题解比较靠后，在第3页
 */
public class Solution1 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        //通过优先级队列建立一个小根堆，比较nums1和nums2对应的值累加，小的在前，大的在后
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();
        //题目说明中已经给出n1,n2,k的取值范围，
        //if (n1 == 0 || n2 == 0 || k == 0) return result;
        //pg存放队首元素下标，参考题解中方法二的图，这里存的是数组下标，不是实际num值，主要是方便定位，控制越界等
        for (int i = 0; i < n1; i++) {
            //这里把第一个数组的全部下标和第二个数组的0标组合
            pq.offer(new int[]{i, 0});
        }
        //条件中有pg.size()>0因为：本题可能存在这种情况：输出结果达不到K对，把组合都输出完了，比如例3：nums1 = [1,2], nums2 = [3], k = 3 ，结果只有：[1,3],[2,3]
        while(pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) {
                //第一个数组的当前下标和第二个数组0标之后的下标组合，加入队列
                pq.offer(new int[]{pair[0], pair[1]+1});
            }
            List<Integer> temp = new ArrayList<>();
            //按照上边的思路，从小往大组合，每次肯定能找到一个最小的
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }
        return result;
    }

}
