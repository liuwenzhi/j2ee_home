package lkhwtk.leetcode414;

import java.util.TreeSet;

/**
 * TreeSet（红黑树）思路，耗时4ms
 */
public class Solution2 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("error");
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            //删除Tree集合最小元素
            if (set.size() > 3){
                set.remove(set.first());
            }
        }
        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }
}
