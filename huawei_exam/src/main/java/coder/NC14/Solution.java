package coder.NC14;

import java.util.ArrayList;

/**
 * NC14 按之字形顺序打印二叉树
 * 本题同leetcode103题，二叉树锯齿形遍历
 */
public class Solution {
    //这道题目就是层次遍历的变形.按照层次遍历的思想先遍历，如3；9，20；15，7；18，16；
    //然后在添加元素的时候把第二行第四行的数据反过来添加到结果中去就可以了
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result  = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)return result;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(pRoot);
        int flag = 1;
        while(list.size()>0){
            ArrayList<Integer> newLine = new ArrayList<Integer>();
            ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
            for(int i = 0; i < list.size(); i++){
                //添加新元素到队列中去
                if(list.get(i).left != null)newList.add(list.get(i).left);
                if(list.get(i).right != null)newList.add(list.get(i).right);
                if(flag == 1){
                    //表示从前往后添加
                    newLine.add(list.get(i).val);
                }
                else{
                    //表示从后往前添加
                    newLine.add(0, list.get(i).val);
                }
            }

            flag = 1-flag;
            list = newList;
            result.add(newLine);
        }
        return result;
    }
}
