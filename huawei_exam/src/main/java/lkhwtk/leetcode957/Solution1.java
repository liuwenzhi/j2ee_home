package lkhwtk.leetcode957;

/**
 * 参考题解：双百解法：位运算+找循环+状态记忆解法，详细思路说明
 * 本题偏重于技巧和整理。知识点补充：
 * 抑或运算：相同为0，不同为1
 * 同或运算：抑或运算的逆运算
 */
public class Solution1 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //将cells转换成二进制数bin，注意将0101这样的数组转成二级制数字的方式，非常巧妙
        int bin = 0;
        int dig = 1;
        for (int i = cells.length - 1; i >= 0; i--) {
            bin += cells[i] * dig;
            dig *= 2;
        }
        //计算第一次变更后的状态，记录为start，数字左移一位，右移一位，做同或运算（抑或取非），然后在和01111110做个与操作，首尾元素置为0
        bin = ~(bin << 1 ^ bin >> 1) & 0x7E;
        int start = bin;
        //memo数组用于存储计算过的状态，8位字符，除去首尾之外，共6个字符，最多64中状态
        int[] memo = new int[64];
        memo[0] = start;
        //轮询计算下一天的状态，直到出现循环
        for (int i = 1; i < N; i++) {
            bin = ~(bin << 1 ^ bin >> 1) & 0x7E;
            if (bin == start) {
                //发现循环后，结束遍历，这里使用N-1方式更好，如果是N%i，则需要判断是否等于0，然后再-1
                bin = memo[(N - 1) % i];
                break;
            } else {
                memo[i] = bin;
            }
        }
        //将最终状态转换回数组，这里为了节省内存，没有创建新数组，而是直接拷贝回cells
        int i = cells.length - 1;
        while (bin > 0) {
            cells[i--] = bin % 2;
            bin /= 2;
        }
        //补位
        while (i >= 0) {
            cells[i--] = 0;
        }
        return cells;
    }
}
