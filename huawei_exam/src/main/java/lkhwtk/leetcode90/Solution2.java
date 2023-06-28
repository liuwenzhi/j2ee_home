package lkhwtk.leetcode90;

import java.util.*;

/**
 * 参考491题优化本题去重方案
 */
public class Solution2 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        //初始调用时，last存一个最小的值
        dfs(0, -11,nums);
        return ans;
    }

    public void dfs(int cur,int last,int[] nums) {
        //System.out.println("cur值:"+cur);
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        //把元素值在递归的过程中一个一个放进去，然后再在递归的过程中一个一个取出来
        //System.out.println("添加元素："+nums[cur]);
        temp.add(nums[cur]);
        dfs(cur + 1,nums[cur], nums);
        temp.remove(temp.size() - 1);
        /*去重，出现重复元素的情况下，前边不选择的时候，选择后面的，参考491题说明，删除当前元素之后，拿当前的last作为下一轮递归的last*/
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
