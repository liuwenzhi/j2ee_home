package lkhwtk.leetcode222;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 层序遍历思路，直接层序遍历效率不是很高，不如Solution
 */
public class Solution1 {
    public int countNodes(TreeNode root) {
        int result = 0;
        if(root==null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result++;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return result;
    }
}
