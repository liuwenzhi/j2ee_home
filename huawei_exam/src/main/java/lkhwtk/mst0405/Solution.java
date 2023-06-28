package lkhwtk.mst0405;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 个人思路：中序遍历，官方解法中序遍历基于栈是实现，时空复杂度和本人差不多
 * 本题同leetcode98题
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i)>=res.get(i+1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 二叉树中序遍历递归算法
     */
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
