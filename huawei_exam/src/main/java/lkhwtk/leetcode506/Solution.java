package lkhwtk.leetcode506;

import java.util.Arrays;

/**
 * 506. 相对名次
 * 参考题解：三种解法，计数排序（2 ms，100.00%）
 * 本题题干中给出的例子有些迷惑性，主要是分数给了个[5, 4, 3, 2, 1]，实际就是代表每个选手的分数，可能是[4,5,6,3,1]
 * 这么一个乱序的分数，按照分数的大小给出具体名次
 */
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] array = new int[n];
        // 拷贝数组，arraycopy具体参数含义直接看源码注释，最后一个n是拷贝的长度，不是目标索引
        System.arraycopy(score, 0, array, 0, n);
        //对拷贝的分数数组进行排序，分数越高，越往后排，最后一位排名第一
        Arrays.sort(array);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            //查找当前成绩排第几名，使用二分查找的方式，到已经排好序的array数组中查找当前score[i]的位置
            //因为array是按照分数从小到大排序，所以拿到的排序实际是反的，用n-array中score[i]的值就是实际最终排名（从1开始到n）
            int index = n - Arrays.binarySearch(array, score[i]);
            switch (index) {
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                    break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = String.valueOf(index);
            }
        }
        return result;
    }
}
