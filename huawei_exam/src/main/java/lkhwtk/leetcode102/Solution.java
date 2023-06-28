package lkhwtk.leetcode102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 核心思路：广度优先遍历加层
 * 在涉及树的计算中，即使不是递归算法，也要注意叶子节点的处理，判断左右子节点是否为null
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //offer比add更好一点，如果链表没空间了，会抛出一个异常
        //queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //在这里做一个队列加层的设计，此时队列中的元素个数，正好是指定某一层的节点个数
            int levelNum = queue.size();
            //for循环中把指定层的节点都弹出，子节点加入队列，然后while下一次循环就是遍历下一层的全部节点
            for(int i=0;i<levelNum;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node2.left = node7;
        node2.right = node8;
        solution.levelOrder(node1);
    }
}
