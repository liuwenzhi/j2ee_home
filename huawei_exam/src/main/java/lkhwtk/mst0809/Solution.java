package lkhwtk.mst0809;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.09. 括号
 * 本题和leetcode22题一致
 */
public class Solution {
    /*二叉树的深度优先遍历，先序遍历*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        // 初始方法path为一个空字符串
        dfs(n, "", res, 0, 0);
        return res;
    }

    /**
     * 二叉树的深度优先遍历
     */
    private void dfs(int n, String path, List<String> res, int left, int right) {
        //方法出口，放入了2n个括号
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        // 优化下回溯剪枝
        if (left < n) {
            dfs(n, path + "(", res, left + 1, right);
        }
        if (right < left) {
            dfs(n, path + ")", res, left, right + 1);
        }
    }
}
