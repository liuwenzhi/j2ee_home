package coder.NC13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * NC13 二叉树的最大深度
 * 本题同leetcode104，offer-55-I
 * 借助队列实现二叉树深度遍历
 */
public class Soluction {
    public int maxDepth (TreeNode root) {
        if(root == null) return 0; //节点为空返回0
        Queue<TreeNode> q = new LinkedList<>(); //开一个队列用于存储遍历树的节点
        q.add(root);
        int n = 0; //用来存储队列的大小
        int res = 0; //用来存最大高度
        while(!q.isEmpty()){ //队列不为空就进行如下操作
            n = q.size();
            for(int i = 0;i < n;i ++){
                TreeNode node = q.poll();//取出队列的第一个元素
                if(node.left != null) q.add(node.left); //左孩子如果不为空就进队列
                if(node.right != null) q.add(node.right); //右孩子如果不为空就进队列
            }
            res ++; //每遍历一层res就++
        }
        return res;
    }
}
