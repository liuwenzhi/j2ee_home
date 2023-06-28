package lkhwtk.leetcode889;

import java.util.Arrays;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 参考题解：图解 889. 根据前序和后序遍历构造二叉树
 */
public class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder==null || preorder.length==0) {
            return null;
        }
        return dfs(preorder,postorder);
    }

    private TreeNode dfs(int[] preorder, int[] postorder) {
        if(preorder==null || preorder.length==0) {
            return null;
        }
        //数组长度为1时，直接返回即可
        if(preorder.length==1) {
            return new TreeNode(preorder[0]);
        }
        //根据前序数组的第一个元素，创建根节点
        TreeNode root = new TreeNode(preorder[0]);
        int n = preorder.length;
        //算法核心：根节点容易找到，通过前序遍历序列找到根节点之后，遍历后序序列，找到preorder[1]==postorder[i]的位置，根据这个位置来拆分左右子树
        //与中序遍历不同的是，数组中没有一个明确的中间节点划分左右子树，左右子树在前序和后序遍历序列数组中是直接下标连续的
        for(int i=0;i<postorder.length;++i) {
            //找到后序遍历的根节点的位置
            if(preorder[1]==postorder[i]) {
                //根据前序数组第二个元素，确定后序数组左子树范围
                int left_count = i+1;
                //拆分前序数组，按照当前根节点的位置，拆出左右两份，注意根节点在数组最前端，Arrays.copyOfRange：前包含后边不包含
                int[] pre_left = Arrays.copyOfRange(preorder,1,left_count+1);
                int[] pre_right = Arrays.copyOfRange(preorder,left_count+1,n);
                //拆分后序数组，按照当前根节点的位置，拆出足有两份，注意根节点在数组最后面
                int[] post_left = Arrays.copyOfRange(postorder,0,left_count);
                int[] post_right = Arrays.copyOfRange(postorder,left_count,n-1);
                //递归执行前序数组左边、后序数组左边
                root.left = dfs(pre_left,post_left);
                //递归执行前序数组右边、后序数组右边
                root.right = dfs(pre_right,post_right);
                break;
            }
        }
        //返回根节点
        return root;
    }

    public static void main(String[] args){
        /*根据例题二叉树层序遍历为： 1 2 3 4 5 6 7来分析下算法思路，前序遍历序列：1 2 4 5 3 6 7，后序遍历序列：4 5 2 6 7 3 1
        * 第一轮递归：根据1建立根节点，然后在核心for循环中找到preorder[1]==postorder[i]，即后序序列中2的位置i为2，定义left_count=i+1=3
        * 在前序遍历数组中截取左半部分：从位置1截取到4（Arrays.copyOfRange前包含后不包含，实际是1到3），左边截取数组为2 4 5，右边截取为3 6 7
        * 在后序遍历数组中截取左半部分：从位置0截取到left_count 3，实际是截取0、1、2三位，拿到左子树4,5,2三个元素，右边数组为6 7 3
        * 接下来分析下第二层递归建立根节点的左子树部分：此时入参为前序遍历序列：[2,4,5]，后序遍历序列[4,5,2]，还是找到了根节点2，然后走
        * 算法核心部分：继续拆数组，找后序遍历中4的位置，找到为0，left_count = i+1=1，前序遍历数组拆为pre_left[4]和pre_right[5],其中
        * pre_left拆分 1到2，只有一个4，pre_right拆分 2到3（3为此时数组长度），只有一个5，后序遍历数组再拆分出post_left[4]，post_right[5]，
        * 在再下一轮的递归过程中，直接将单节点作为左右子树的根节点返回。整个过程缕清这个思路即可。
        */
        int[] a = {0,1,2};
        //Arrays.copyOfRange根据位置拆分数组，前包含后不包含
        int[] left = Arrays.copyOfRange(a,2,3);
    }
}
