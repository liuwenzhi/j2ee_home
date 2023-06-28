package lkhwtk.leetcode384;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 384. 打乱数组
 * 核心思路：利用已有框架Collections的shuffle方法打乱数组
 */
public class Solution {

    /**
     * 单独用一个数组保存原始数组
     */
    private int[] origin;

    public Solution(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] target = new int[origin.length];
        List<Integer> list = new ArrayList<>();
        for (int i : origin) {
            list.add(i);
        }
        //利用shuffle来随机打乱数组
        Collections.shuffle(list);
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
