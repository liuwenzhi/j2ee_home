package lkhwtk.leetcode650;

/**
 * 650. 只有两个键的键盘
 * 参考题解：官方
 * 本题官方题解9月10号之后更新了
 */
public class Solution {
    public int minSteps(int n) {
        //f[i] 表示打印出 i 个A 的最少操作次数，显而易见，f[0]=0,f[1]=0
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            //f[i] = Integer.MAX_VALUE;题目说明中给了，n<=1000，f[i]最大操作i次，拷贝一次，粘贴i-1次，比如f[1000],拷贝一次，粘贴999次，正好得到1000个A
            f[i] = i;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    //基于j个A的情况，拷贝一次，粘贴 i/j-1次，正好得到i个A
                    f[i] = Math.min(f[i], f[j] + i / j);
                    //基于i/j个A的情况，拷贝一次，粘贴j-1次，正好得到i个A
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}
