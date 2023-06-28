package lkhwtk.leetcode292;

/**
 * 292. Nim 游戏
 * 本题是一道逻辑推理题
 * 参考题解：Nim 游戏 官方
 * 作为Nim游戏模板记一下
 */
public class Solution {
    public boolean canWinNim(int n) {
        //只要自己面对的不是4，想办法把4抛给对手，自己就是胜利者
        return (n % 4 != 0);
    }
}
