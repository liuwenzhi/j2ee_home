package lkhwtk.leetcode107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历 II
 * 本题和102题极其类似，就是返回方式按照从下到上返回，102题是按照从上到下返回
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //queue.add(root);
        //offer比add更好一点，如果链表没空间了，会抛出一个异常
        queue.offer(root);
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
            //本题和102题唯一的区别，最后拿到level队列之后，加载到result的头部
            result.add(0,level);
        }
        return result;
    }
}
