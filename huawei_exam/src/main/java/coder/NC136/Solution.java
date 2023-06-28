package coder.NC136;
import java.util.*;

/**
 * NC136 输出二叉树的右视图
 * 本题属于leetcode105,199题的组合
 */
public class Solution {
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = reBuild(xianxu, zhongxu);
        return bfs(root);
    }

    public TreeNode reBuild (int[] preOrder, int[] inOrder) {

        if (preOrder == null || preOrder.length == 0) return null;

        int val = preOrder[0], pos = 0, len = preOrder.length;
        TreeNode root = new TreeNode(val);

        // 找到中序数组中根节点位置
        for(; pos < len; pos++){
            if (inOrder[pos] == val) break;
        }
        // 左右子树继续拆分，递归重构
        // 此处 Arrays.copyOfRange 方法起点为 len 不抛异常，返回[]，对应递归结束条件。
        root.left = reBuild(Arrays.copyOfRange(preOrder, 1, pos + 1),
                Arrays.copyOfRange(inOrder, 0, pos));
        root.right = reBuild(Arrays.copyOfRange(preOrder, pos + 1, len),
                Arrays.copyOfRange(inOrder, pos + 1, len));

        return root;
    }

    public int[] bfs(TreeNode root){

        if (root == null) return null;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (TreeNode tmp = root; !queue.isEmpty(); ){
            // 此处注意循环中 queue.size() 在变，应事先记录 size--
            for (int size = queue.size(); size > 0; size--){
                tmp = queue.poll();
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            // 添加每层最右元素
            list.add(tmp.val);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
