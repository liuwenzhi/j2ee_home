package lkhwtk.offer32_I;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 官方给出的广度优先遍历代码，参考下简化代码。
 * 在初始化队列的时候，直接add一个root，在本地编译的时候，需要将 new LinkedList<TreeNode> 这个泛型标记好
 *
 */
public class Solution1 {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
