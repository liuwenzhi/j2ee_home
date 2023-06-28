package lkhwtk.leetcode1004;

/**
 * 参考题解：分享滑动窗口模板，秒杀滑动窗口问题
 * 这个思路更好，判断一个窗口中0的值是否超过了K，本题只有0和1，可以这么搞，424题是全部字母，不能这么弄了
 */
public class Solution1 {
    public int longestOnes(int[] A, int K) {
        int N = A.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (A[right] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (A[left++] == 0)
                    zeros --;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}
