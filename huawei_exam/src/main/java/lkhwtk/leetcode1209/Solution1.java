package lkhwtk.leetcode1209;

/**
 * 参考题解：官方
 * Solution的优化方案，采用计数法，减少一层循环
 */
public class Solution1 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    //每次删除完数据之后，i退到删除位置i - k + 1的前一个位置，比如abbbcc，删除b的时候，k=3，i=3,删除的位置是从1开始（i-k+1），删除到c前边这个元素
                    //删除完了之后，i退回到a这个位置，即i-k=0
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
