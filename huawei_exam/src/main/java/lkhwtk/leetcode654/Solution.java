package lkhwtk.leetcode654;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 * 个人思路参考官方题解
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length);
    }

    private TreeNode buildTree(int[] nums,int left,int right){
        //递归方法出口，开始考虑放一个root节点过来，判断是否为null，那么做越做越乱，这个递归的出口，类似二分查找
        if(left==right){
            return null;
        }
        int maxIndex = getMaxNum(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums,left,maxIndex);
        root.right = buildTree(nums,maxIndex+1,right);
        return root;
    }

    /**
     * 返回一个数组在指定空间最大值的位置，直接返回位置即可，最大值可以通过数组获取，从官方题解找到这么一个技巧
     * 获取最大值范围包括left，不包括right
     */
    private int getMaxNum(int[] nums,int left,int right){
        int maxIndex = left;
        for(int i=left;i<right;i++){
            if(nums[maxIndex]<nums[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,6,0,5};
        System.out.println(Arrays.stream(nums).max().getAsInt());
    }
}
