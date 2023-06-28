package lkhwtk.offer36;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 参考题解：剑指 Offer 36. 二叉搜索树与双向链表（中序遍历，清晰图解）
 * 核心思路：基于二叉查找树的性质，通过中序遍历拿到从小到大的节点排列，然后找到当前节点和前置节点，
 * 前置节点的left指向当前节点，当前节点的left指向前置节点，注意一定要同时有，头结点和尾节点单独处理一下
 */
public class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        //递归结束之后，head节点是头结点，pre节点是中序遍历最后一个节点，即尾节点，单独设置下指针指向
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) {
            return;
        }
        //递归遍历左子树，一直到找到出口之后，先找到最小的节点，此时cur指向的就是最小的节点
        dfs(cur.left);
        if(pre != null) {
            //前置节点不为null的情况下，前置节点右指针指向当前节点
            pre.right = cur;
        }else {
            //第一次指向最小节点的情况下，让head指向这个最小的节点，前驱节点pre初始化为null，此时还没有被赋值
            head = cur;
        }
        //cur节点左指针指向前置节点，只有最小节点的pre节点没有被初始化，此时先指向null
        cur.left = pre;
        //pre向后移动一位，cur节点作为前置节点，然后去遍历右子树
        pre = cur;
        dfs(cur.right);
    }



}
