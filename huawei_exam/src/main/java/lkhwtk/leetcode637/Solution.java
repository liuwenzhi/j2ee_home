package lkhwtk.leetcode637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * 本题和515题存在一定关联性，借助队列来实现遍历二叉树每一层的元素
 * 注意：本题会有计算越界的情况，节点的值会达到整形最大数字
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        //借助n队列存放二叉树的节点
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            //初始化一个每行节点val和为0
            double lineSum = 0;
            //本次遍历过程中，先把size拿出来，在for循环中会弹出当前层的全部节点，然后把当前层全部节点的左右子节点加入到队列中
            int size = nodeQueue.size();
            for(int i=0;i<size;i++){
                TreeNode node = nodeQueue.poll();
                //lineSum已经定义为double类型，直接和整形相加，转成double，这里如果是定义lineSum为整形，则可能会出现计算越界的情况
                //这里之前用了Double.parseDouble(node.val+"");这种方式进行强转，时间消耗增加了5到6倍，用现在这种方式时空复杂度都能达到最优
                lineSum += node.val;
                if(node.left!=null){
                    nodeQueue.offer(node.left);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                }
            }
            //for循环结束之后，当前层的节点都弹出来了，当前层节点全部左右子节点入队
            result.add(lineSum/size);
        }
        return result;
    }

}
