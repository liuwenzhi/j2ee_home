package lkhwtk.offer34;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 本题和leetcode113题是同一题，刚刚刷完113就碰offer34，可能这也是一种幸福，哈哈
 */
public class Solution {
    /**返回结果集合*/
    private List<List<Integer>> result;
    /**递归过程中，涉及到元素的进出，用队列来模拟进出的容器非常方便*/
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new ArrayList<>();
        dfs(root,target);
        return result;
    }

    public void dfs(TreeNode root, int target) {
        //递归方法出口，如果遍历的节点是null，此时肯定还没取到结果
        if(root==null){
            return;
        }
        //从队列尾端加入元素
        path.offer(root.val);
        //和112题类似，每次还是让targetSum递减，这样就避免了在每层递归方法中通过一个for循环进行累加的操作
        target -= root.val;
        //递归方法出口，遍历到了叶子节点
        if(root.left==null&&root.right==null&&target==0){
            //注意：可以通过这种方式将队列转成列表，很方便
            result.add(new LinkedList<>(path));
        }
        //递归左右子树，递归完了之后把当前元素弹出，队列进队的方式采用后进后出
        dfs(root.left,target);
        dfs(root.right,target);
        //从队列尾端弹出元素
        path.pollLast();
    }
}
