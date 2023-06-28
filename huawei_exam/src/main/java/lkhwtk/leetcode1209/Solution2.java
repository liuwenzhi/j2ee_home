package lkhwtk.leetcode1209;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 参考题解：官方
 * 借助栈实现
 */
public class Solution2 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        //Stack<Integer> counts = new Stack<>();
        Deque<Integer> counts = new LinkedList<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts.push(1);
            } else {
                int incremented = counts.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    //每次删除完数据之后，i退到删除位置i - k + 1的前一个位置
                    i = i - k;
                } else {
                    counts.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
