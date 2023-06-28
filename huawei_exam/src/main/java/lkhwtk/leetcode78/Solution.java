package lkhwtk.leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 参考题解：官方。本题和491题类似，递归+回溯
 * 本题是遍历一个数组全部子集的标准模板
 */
public class Solution {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur,int[] nums) {
        //System.out.println("cur值:"+cur);
        if (cur == nums.length) {
            //System.out.println("-------------------------");
            System.out.println(temp);
            //System.out.println("-------------------------");
            ans.add(new ArrayList<Integer>(temp));
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
        solution.subsets(a);
    }
}
