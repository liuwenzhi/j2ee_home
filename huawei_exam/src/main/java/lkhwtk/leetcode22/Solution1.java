package lkhwtk.leetcode22;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    /*二叉树的深度优先遍历，先序遍历*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        //注意：根节点从空字符串开始
        dfs(n, "", res,0,0);
        return res;
    }

    /**
     * Solution方案换一种写法，这种方案因为没有回溯的过程，效率能稍微好一点点
     * 主要是在递归条件这块直接控制，左括号小于n，递归过程中最终的结果是左括号数等于n，
     * 右括号小于左括号，递归过程中最终的结果是右括号数等于左括号数
     */
    private void dfs(int n, String path, List<String> res,int left,int right) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        //优化下回溯剪枝
        if(left<n){
            dfs(n, path + "(", res,left+1,right);
        }
        if(right < left){
            dfs(n, path + ")", res,left,right+1);
        }
    }
}
