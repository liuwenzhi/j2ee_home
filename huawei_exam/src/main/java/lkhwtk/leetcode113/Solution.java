package lkhwtk.leetcode113;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 本题采用112题递归思路
 * 参考题解：官方
 */
public class Solution {
    /**返回结果集合*/
    private List<List<Integer>> result;
    /**递归过程中，涉及到元素的进出，用队列来模拟进出的容器非常方便*/
    private Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        dfs(root,targetSum);
        return result;
    }

    public void dfs(TreeNode root, int targetSum) {
        //递归方法出口，如果遍历的节点是null，此时肯定还没取到结果
        if(root==null){
            return;
        }
        //从队列尾端加入元素
        path.offer(root.val);
        //和112题类似，每次还是让targetSum递减，这样就避免了在每层递归方法中通过一个for循环进行累加的操作
        targetSum -= root.val;
        //递归方法出口，遍历到了叶子节点
        if(root.left==null&&root.right==null&&targetSum==0){
            //注意：可以通过这种方式将队列转成列表，很方便
            result.add(new LinkedList<>(path));
        }
        //递归左右子树，递归完了之后把当前元素弹出，队列进队的方式采用后进后出
        dfs(root.left,targetSum);
        dfs(root.right,targetSum);
        //从队列尾端弹出元素
        path.pollLast();
    }
}
