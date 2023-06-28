package lkhwtk.leetcode515;

import java.util.*;

/**
 * 515. 在每个树行中找最大值
 * 暂时只能想到层序遍历里边再套一层循环，真的考虑不到其他好的方式了。
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int lineMax = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            //本次遍历过程中，先把size拿出来，在for循环中会继续把当前层的左右子节点加入到队列中
            int size = nodeQueue.size();
            //注意通过for循环遍历队列元素的方式
            for(int i=0;i<size;i++){
                TreeNode node = nodeQueue.poll();
                lineMax = Math.max(lineMax,node.val);
                if(node.left!=null){
                    nodeQueue.offer(node.left);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                }
            }
            result.add(lineMax);
            //每次遍历完一层之后，把最小值重置
            lineMax = Integer.MIN_VALUE;
        }
        return result;
    }
}
