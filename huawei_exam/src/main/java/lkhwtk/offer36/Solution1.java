package lkhwtk.offer36;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution递归思路不太好理解，直接按照本人优化版本，先拿到中序遍历序列，注意：这里的递归List列表不是存的树的值，而是
 * 直接存储树的节点，拿到这个排列之后，再重新组装下root，组装方式可以参考Solution
 */
public class Solution1 {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        List<Node> result = new ArrayList<>();
        dfs(result,root);
        for(Node cur:result){
            if(pre != null) {
                //前置节点不为null的情况下，前置节点右指针指向当前节点
                pre.right = cur;
            }else {
                //第一次指向最小节点的情况下，让head指向这个最小的节点，前驱节点pre初始化为null，此时还没有被赋值
                head = cur;
            }
            //cur节点左指针指向前置节点，只有最小节点的pre节点没有被初始化，此时先指向null
            cur.left = pre;
            //pre向后移动一位，当前cur节点作为前置节点
            pre = cur;
        }
        //头和尾再关联一下
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 二叉树中序遍历递归算法
     */
    void dfs(List<Node> result, Node root) {
        if(root == null){
            return;
        }
        dfs(result,root.left);
        result.add(root);
        dfs(result,root.right);
    }
}
