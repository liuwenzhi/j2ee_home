package lkhwtk.leetcode1282;

import java.util.ArrayList;
import java.util.List;

/**
 * 1282. 用户分组
 * 思路1：重复遍历，相对比较暴力，但是很取巧的一个思路
 * 分组数相同的元素分到一个组里边去
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            //算法将分好组的元素值置为-1，后边不用管
            if(groupSizes[i]==-1){
                continue;
            }
            ArrayList<Integer> group = new ArrayList<>();
            //拿到外层循环的分组值后，通过内层循环遍历groupSizes，如果分组相等同时group没有超量，就放到group中
            int temp = groupSizes[i];
            for(int j=0;j<groupSizes.length;j++){
                if(groupSizes[j]==-1){
                    continue;
                }
                if(groupSizes[j]==temp&&group.size()<temp){
                    group.add(j);
                    groupSizes[j]=-1;
                }
                if(group.size()==temp){
                    break;
                }
            }
            result.add(group);
        }
        return result;
    }
}
