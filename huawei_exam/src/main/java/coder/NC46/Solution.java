package coder.NC46;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * NC46 加起来和为目标值的组合
 * 本题未完全完成，核心思路已经没问题了，主要是去重这一块，后边找时间再看下
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private boolean[] used;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        this.used = new boolean[num.length];
        Arrays.sort(num);
        find(0,0,num,target,new ArrayList<Integer>());
        return result;
    }

    /**
     * @param pre 累加和
     * @param begin 遍历num数组开始位置
     * @param num 原始数组
     * @param target 目标值
     * @param list 保存临时统计的一维列表
     */
    public void find(int pre,int begin,int[] num,int target,ArrayList<Integer> list){
        //递归方法出口
        if(pre==target){
            //如果累加和达到target就添加到result集合中
            ArrayList<Integer> list1 = new ArrayList<>(list.size());
            list1.addAll(list);
            result.add(list1);
        }else if(pre > target){
            //如果累加和超过范围就返回
            return;
        }
        for(int i=begin;i<num.length;i++){
            if(!used[i]) {
                //如果元素值本身就大于target，跳过，元素标记一个已使用，不妨到result列表中
                if(num[i]>target){
                    used[i] = true;
                    continue;
                }
                if(pre + num[i] > target){
                    continue;
                }
                //加一步去重操作
                if(i>0&&num[i]==num[i-1]){
                    continue;
                }
                pre += num[i];
                list.add(num[i]);
                used[i] = true;
                find(pre, i+1,num, target, list);
                used[i] = false;
                list.remove(list.size() - 1);
                pre -= num[i];
            }
        }
    }

    public static void main(String[] args){
        int[] a = {100,10,20,70,60,10,50};
        Solution solution = new Solution();
        solution.combinationSum2(a,80);
    }
}
