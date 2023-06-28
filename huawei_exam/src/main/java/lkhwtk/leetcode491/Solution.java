package lkhwtk.leetcode491;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 * 参考题解：官方递归+回溯思路,注意子序列的特点：在数组中的前后顺序不能变，可以不连续：本题不能使用改变nums数组中元素的顺序。
 * 子序列类似于子集，本题要求子序列中至少有两个元素，这个和子集不一样。注意区别下子数组，子数组是元素顺序必须连续的，顺序也不能变。
 * 最终的结果输出可以不用管顺序，原始顺序可能有增有减
 */
public class Solution {
    /**
     * 临时列表，在递归和回溯过程中，添加设删除元素，temp最终会放到ans中
     */
    List<Integer> temp = new ArrayList<>();
    /**
     * 最终结果列表
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        //-101这个值根据题目中给的说明设置的，-100 <= nums[i] <= 100，last参数传一个能取到的最小值
        dfs(0, -101, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                //这里保存注意下，不能是直接加入temp，可能什么也没有，不知道这个是不是和temp是类属性有关。
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        //当前元素大于等于之前最大的这个元素，才是合法（保证是递增子序列），如果两个元素相同，那么第一个被选择了第二个一定会被选择
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        /*去重，如果前后两个元素一致，则存在前者被选择，后者不被选择和前者不被选择，后者被选择两种情况重复的问题，如果二者都被选择或者都不被选择，不会重复
         *注意：这里的去重方式是：前者不被选择的时候选择后者，而不是前者选择的时候不选择后者，结合Test中的递归流程，4677输出完之后，最后一个7执行remove，
         * 然后执行最后一个if判断，此时不满足条件，nums[cur]是7，last也是7，没有出现保留第一个7而不保留第二个7的情况，然后第二个递归没有走。然后一直到第一
         * 个7被删除的时候，nums[cur]是7最后一个7，last是6，走第二个if循环，进入下一轮dfs，这个时候nums[cur]是最后一个7，再加进来，走下一轮递归，做路径输出。
         * 最后一个递归选择当前last作为下一轮last的值，因为去掉最后一个元素之后，最后一个元素就不能作为下一轮递归的last了，需要用当前的last值放到下一轮去比
         * 对，这一点开始理解了递归之后就明了了，就是这里有点绕。
         */
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
