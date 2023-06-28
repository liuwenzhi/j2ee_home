package lkhwtk.leetcode1372;

/**
 * 1372. 二叉树中的最长交错路径
 * 参考题解：C++双百题解，dfs深搜，菜鸡先写为敬。通过C++的代码整理下java算法思路
 * 可以在配合下官方题解，对开始初始化路径长度为0，重置的时候置路径长度为1的详细说明
 */
public class Solution {

    private int result = 0;
    public int longestZigZag(TreeNode root) {
        //递归遍历左子树，注意遍历从0开始,root节点没有父节点，路径为0
        dfs(root,false,0);
        //递归遍历右子树
        dfs(root,true,0);
        return result;
    }

    /**
     * 核心递归方法
     * @param root 当前遍历的树节点
     * @param dir 左子树：false(0)，右子树：true(1)
     * @param length 之字形路径长度
     */
    private void dfs(TreeNode root,boolean dir,int length){
        //递归方法出口，遍历到了叶子节点的下一级
        if(root ==null){
            return;
        }
        //返回路径最大值
        result = result>length?result:length;
        //当前节点root是右子树的情况，dir=true(1)
        if(dir){
            //按照之前的路径从当前节点root只能往左找
            dfs(root.left,false,length+1);
            //搜索其右孩子时，不满足ZigZig，路径长度置为1，这里是一步补充，应该向左走，当前节点可能没有左子树，只能向右，这个时候就要更改当前节点的路径值为1，
            //从root到root.right，相当于重新算一条路径了
            dfs(root.right,true,1);
        }else{
            //当前节点root是左子树的情况，dir=false(0)，按照之前下来的路径只能往右找
            dfs(root.right,true,length+1);
            //搜索其左孩子时，不满足ZigZig，路径长度置为1
            dfs(root.left,false,1);
        }
    }
}
