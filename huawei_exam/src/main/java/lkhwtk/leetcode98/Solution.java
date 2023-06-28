package lkhwtk.leetcode98;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 个人思路：中序遍历二叉树，得到的序列必须是一个完整的从小到大的递增序列
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return checkList(res);
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

    private boolean checkList(List<Integer> res){
        //如果树是空的，或者只有一个节点，则直接fanhuitrue
        if(res.size()==0||res.size()==1){
            return true;
        }
        //设计两个指针，一个从0指向n-1，一个从1指向n，判断相邻的两个元素大小，前边的必须比后边的小才行
        for(int i=0,j=1;i<res.size()-1&&j<res.size();i++,j++){
            if(res.get(i)>=res.get(j)){
                return false;
            }
        }
        return true;
    }
}
