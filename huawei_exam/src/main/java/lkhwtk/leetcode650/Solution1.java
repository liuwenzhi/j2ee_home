package lkhwtk.leetcode650;

/**
 * 650. 只有两个键的键盘
 * 参考题解：官方
 * 本题官方题解9月10号之后更新了
 * 参考题解：【宫水三叶】一题三解 :「动态规划」&「数学」&「打表」
 * 核心思路：将本题转换为拆分n的全部质因数，本题数学思路没有完全理解但是效率非常高
 */
public class Solution1 {
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }
        if (n != 1){
            ans += n;
        }
        return ans;
    }
}
