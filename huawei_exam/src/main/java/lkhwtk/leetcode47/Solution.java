package lkhwtk.leetcode47;

import java.util.*;

/**
 * 47. 全排列 II
 * 参考题解：官方黑体字。
 * 本题和46题的区别在于这里不能保存重复的数字，可以基于46题的回溯模板，重点是24行和39行。
 * 24行优化为先对nums数组进行一次排序，39行是去重，在排序之后，重复的数字都是挨着的，这里
 * 的去重方式是：后边的重复数字要添加到集合中，必须保证前边的已经添加过，否则不能添加。这种设计实际和40题去重思路一致。
 * 这种设计保证了重复数字按从左到右的顺序只出现一次
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        //返回值空列表初始化为一个动态列表
        List<List<Integer>> result = new ArrayList<>();
        if(length==0){
            return result;
        }
        //注意定义队列的方式，和39题、40题一致
        Deque<Integer> path = new ArrayDeque<>();
        //对数组排个序，去重使用
        Arrays.sort(nums);
        //记录已经使用的数组元素，默认为false，不用初始化
        boolean[] used = new boolean[length];
        dfs(nums,length,0,path,used,result);
        return result;

    }
    private void dfs(int[] nums,int length,int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> result){
        //第一步：递归终止条件，遍历的深度达到了数组的长度，则将path放到result里边
        if(depth==length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<length;i++){
            //数组排序之后，在进行排列数据的时候，只有前一个重复的数字用过了，才能用后边一个排序的数字，也可以先用后边的再用前边的，太麻烦
            if(used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])){
                continue;
            }
            //从队尾添加
            path.add(nums[i]);
            used[i] = true;
            //进行下一层的递归
            dfs(nums,length,depth+1,path,used,result);
            //之后回到上一层，之前做了什么，之后就需要做同样的逆操作，这个过程就是回溯
            used[i] = false;
            //从队尾删除
            path.removeLast();
        }

    }
}
