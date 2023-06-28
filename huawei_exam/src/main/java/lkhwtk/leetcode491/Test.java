package lkhwtk.leetcode491;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归枚举子序列的通用模板
 * 递归过程简单梳理：首先：4/cur:0,6/cur:1,7/cur:2,7/cur:3,执行最后一个7的第一个递归，输出4,6,7,7，然后返回
 * 执行最后一个7,的remove，注意此时cur值是3，temp中4,6,7，执行最后一个7的第二个递归，cur值增加变成4，等于nums.length，输出4,6,7，然后返回
 * 回到4/cur:0,6/cur:1,7/cur:2这一步，执行倒数第二个7的remove，temp中4,6，执行倒数第二个7的第二个递归，
 * 可以得到结果4,6,7和4,6，这两个情况是倒数第二个7倍去掉之后，最后一个7可能有，也可能没有。然后继续返回，
 * 回退到4/cur:0,6/cur:1 这一步，这时候就是6没有，然后后边477,47,47，以此类推。
 * 本算法要理解return是return到哪里，通过cur和temp组合控制的方式。
 */
public class Test {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
            ans.add(new ArrayList<Integer>(temp));
            System.out.println(temp.toString());
            return;
        }
        //添加当前元素
        temp.add(nums[cur]);
        //添加当前元素之后递归下一级
        dfs(cur + 1, nums);
        //删除当前元素
        temp.remove(temp.size() - 1);
        //去掉当前元素之后递归下一级
        dfs(cur + 1, nums);
    }

    public static void main(String[] args){
        int[] nums = {4,6,7,7};
        Test test = new Test();
        test.dfs(0,nums);
    }
}
