package lkhwtk.leetcode22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 参考题解：老汤视频题解：简单易懂Java/C++ /Python/js 培养抽象思维【回溯解法】- 括号生成，
 * 本题抽象为二叉树的遍历，考查知识点非常全面，包括递归，二叉树的深度优先遍历（先序遍历），
 * 回溯（二叉树减枝）等，重点看下。官方说明视频2后边有一个贪心，回溯，动态规划刷题说明，后边重点看下。
 * 注意括号生成合法性验证的一个点：左括号的个数总是大于等于有括号的个数
 * 本题同面试题08.09
 */
public class Solution {
    /*二叉树的深度优先遍历，先序遍历*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        //注意：根节点从空字符串开始
        dfs(n, "", res, 0, 0);
        return res;
    }

    /**
     * 深度优先遍历，实际是模拟了根节点，左子树，右子树的递归遍历方式
     * 当n=2时，直接深度优先遍历会遍历出((((，))))这种情况，n等于其他值也是这样，产生很多不正确的括号，必须要进行剪枝
     */
    private void dfs1(int n, String path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs1(n, path + "(", res);
        dfs1(n, path + ")", res);
    }

    /**
     * 在dfs1的基础上，增加剪枝的效果，实际就是过滤掉递归二叉树中不满足条件的记录
     * 比如((((或者))))，这里有一个细节注意下：题目要有有效的括号组合，)(这种不
     * 行，一定是左括号在左，右括号在右。所以整个递归过程中，绝对不能出现右括号
     * 比左括号多，最后一个肯定是右括号
     */
    private void dfs(int n, String path, List<String> res, int left, int right) {
        //增加剪枝功能，避免过多遍历，注意 left和right都可以等于n，因为是以空字符串为根进行遍历，剪枝的方案可以通过观察dfs1的遍历结果得出
        if (left > n || right > left) {
            //如果在这里回退的话，回退之后left的值和right的值还是原来的值，如果往下走了dfs才更深一步进行自增，递归中这一步骤相当于回溯
            return;
        }
        //递归方法出口，路径长度达到了2*n
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, left + 1, right);
        dfs(n, path + ")", res, left, right + 1);
    }
}
