package lkhwtk.leetcode257;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 个人思路，递归遍历左右子树拼路径
 * 以下题解后边可以看下，关于二叉树遍历的说明比较全面
 * 257. 二叉树的所有路径4种解法（图文详解）
 * 谈谈别的，前、中、后序遍历的区别只有一点
 */
public class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }
        buildPath(root,root.val+"");
        return result;
    }

    private void buildPath(TreeNode root,String path){
        //递归方法出口
        if(root.left==null&&root.right==null){
            result.add(path);
        }
        if(root.left!=null){
            buildPath(root.left,path+"->"+root.left.val);
        }
        if(root.right!=null){
            buildPath(root.right,path+"->"+root.right.val);
        }

    }
}
