package lkhwtk.offer58_II;

/**
 * 参考题解：官方
 * 官方题解是对本人题解很好的优化
 */
public class Solution1 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
