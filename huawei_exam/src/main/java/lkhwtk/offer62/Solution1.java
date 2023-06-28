package lkhwtk.offer62;

/**
 * 参考题解：Java解决约瑟夫环问题，告诉你为什么模拟会超时！
 * 用数学方法进行反推：(当前index + m) % 上一轮剩余数字的个数
 * 备注：约瑟夫环有数学的求解方法，题解中数学方法可以背一下
 */
public class Solution1 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
