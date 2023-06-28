package lkhwtk.leetcode997;

/**
 * 997. 找到小镇的法官
 * 参考题解：超过100% Java 双数组 简单易懂
 * 这个思路更好，充分利用下人的编号是跟数组下标一致的。
 */
public class Solution {
    public int findJudge(int N, int[][] trust) {
        //相信其他人数组
        int[] arr1 = new int[N + 1];
        //被相信的数组
        int[] arr2 = new int[N + 1];
        for (int[] t : trust) {
            arr1[t[0]] += 1;
            arr2[t[1]] += 1;
        }
        for (int i = 1; i < arr1.length; i++) {
            //如果不相信任何人，同时被其他人都相信
            if (arr1[i] == 0&&(arr2[i] == N - 1)) {
                return i;
            }
        }
        return -1;
    }
}
