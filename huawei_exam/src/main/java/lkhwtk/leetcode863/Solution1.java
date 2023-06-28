package lkhwtk.leetcode863;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 参考题解：改变树的形状！ 父子局の反转！ c++ 思路+代码
 * 核心思路：拆二叉树，可以看下题解下边评论中的java版本代码，思路中拆出两个二叉树，最核心的点在这里：
 * 算法文字区域最后一句：如果它爸爸将它的位置给了它爷爷，那刚好可以用完二叉树的两个儿子位。正好拆出
 * 了两个二叉树，一个以target节点为根，一个以target节点的父节点为根
 * 备注：本人一轮刷题时间是7月23日，官方题解7月28日给出，比这个题解好理解很多。重点参考Solution
 */
public class Solution1 {
    List<Integer> result = new ArrayList<>();
    //node2存储目标节点的爸爸
    TreeNode node2;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        /*首先把树分为两棵，一棵以目标节点为根，一棵以目标节点爸爸为根，爸爸指向目标节点这个枝改为指向爷爷节点，爷爷节点再指向爷爷节点的父节点，一直到根节点
        这样就保证了正好拆出两棵树，注意：在初次调用该方法过程中，并不知道父节点，需要在递归中找到*/
        dfs(root, target, null);
        // 搜索以目标节点为根的树深度为k的节点
        collect1(target, 0, k);
        // 搜索以目标节点爸爸为根的树深度为k-1的节点
        collect1(node2, 0, k - 1);
        return result;
    }

    /**
     * 该方法将入参的二叉树一分为二，主要是找从根节点开始，找目标节点target的父节点，找到之后
     * 需要将从target到父节点的关系拆出，target的父节点，到爷爷节点再一直到root节点的父子指向关系都改变
     */
    public Boolean dfs(TreeNode root, TreeNode target, TreeNode father) {
        if (root == null) {
            return false;
        }
        // 如果搜到了目标节点，那么它爸爸就是新树的根，第一轮递归时，如果root节点就是target，那么father是null
        if (root == target) {
            node2 = father;
            // 递归的时候返回：我们解除父子关系
            return true;
        }
        //target节点在root节点的左子树上，那么就顺着左子树一层一层往下找，往上看dfs函数入参，那么root的left指向father，让原来的左儿子即target独立出去。
        //注意这里是核心的点，也是非常不好理解的一个点：这里是从儿子节点往父亲节点上一级一级的递归返回，一直到原来的root节点left指向了null
        if (dfs(root.left, target, root)) {
            root.left = father;
            // 递归的时候：我是你爸爸
            return true;
        }
        // 如果我成了我右儿子的儿子，那我的爸爸就是我的新的右儿子，想想斜着往上的箭头
        if (dfs(root.right, target, root)) {
            root.right = father;
            return true;
        }
        // 递归的时候返回：爸爸
        return false;
    }

    // 搜索以k为根节点的树的第k层所有节点，随便拿dfs写的，这里也可以层序遍历
    public void collect(TreeNode root, int n, int k) {
        if (root == null) {
            return;
        }
        // 如果达到指定搜索深度，返回搜寻结果
        if (n == k) {
            result.add(root.val);
        } else {
            collect(root.left, n + 1, k);
            collect(root.right, n + 1, k);
        }
    }

    /**
     * 基于广度优先遍历，获取值
     */
    public void collect1(TreeNode root, int n, int k){
        if (root == null) {
            return;
        }
        if(n==k){
            result.add(root.val);
        }else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                if(n==k){
                    for(int i=0;i<size;i++){
                        TreeNode node = queue.poll();
                        result.add(node.val);
                    }
                    break;
                }else {
                    //将同层的弹出，并将子节点加入队列
                    for (int i = 0; i < size; i++) {
                        TreeNode node = queue.poll();
                        //注意：入队列一定要增加是否为null的判断，叶子节点为null是会被加入到队列中的
                        if(node.left!=null) {
                            queue.add(node.left);
                        }
                        if(node.right!=null) {
                            queue.add(node.right);
                        }
                    }
                    n++;
                }
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        Solution1 solution = new Solution1();
        solution.distanceK(root,node5,2);

    }

}
