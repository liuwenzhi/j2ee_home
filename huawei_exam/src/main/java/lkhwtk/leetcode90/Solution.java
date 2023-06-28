package lkhwtk.leetcode90;

import java.util.*;

/**
 * 90. 子集 II
 * 基于78题进行的优化，注意：本题求的是子集，不是子数组，只要集合中元素都包含就行，可以不考虑顺序
 * 需要先进行一下排序，让重复的元素放到一块去，然后按照重拍后这个顺序再去处理。
 */
public class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    /**
     * 基于set集合去重
     */
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        for(List<Integer> list:set){
            ans.add(list);
        }
        return ans;
    }

    public void dfs(int cur,int[] nums) {
        //System.out.println("cur值:"+cur);
        if (cur == nums.length) {
            set.add(new ArrayList<Integer>(temp));
            return;
        }
        //把元素值在递归的过程中一个一个放进去，然后再在递归的过程中一个一个取出来
        //System.out.println("添加元素："+nums[cur]);
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        temp.remove(temp.size() - 1);
        //System.out.println("移除元素："+nums[cur]);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {1,2,2};
        solution.subsetsWithDup(a);
    }
}
