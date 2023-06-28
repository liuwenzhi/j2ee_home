package lkhwtk.offer38;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 参考题解：剑指 Offer 38. 字符串的排列（回溯法，清晰图解）
 * 本题该算法细节非常多，理解起来很麻烦，可以看下题解下边的评论，很多说的很好
 * 二轮复习时候有需求看下
 */
public class Solution1 {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    /**
     * 深度优先遍历递归
     */
    void dfs(int x) {
        //递归出口，走到了最后一个元素
        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            dfs(x + 1);
            // 恢复交换
            swap(i, x);
        }
    }

    /**
     * 交换数组c中两个元素的位置
     */
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args){
        Solution1 solution = new Solution1();
        solution.permutation("aab");
    }
}
