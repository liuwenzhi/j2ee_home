package lkhwtk.leetcode77;

import java.util.ArrayList;
import java.util.List;

/**
 * 模仿78题用直接用List<Integer>存临时路径
 */
public class Solution1 {
    /**
     * 1到n的k个数的组合
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        //Deque<Integer> path = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, List<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            //注意，本题添加List路径也得new 一下才行，不然拿到会是空的
            res.add(new ArrayList<>(path));
            //res.add(path);
            return;
        }

        // 遍历可能的搜索起点，这里条件为：i<=n即可，i <= n - (k - path.size()) + 1是一步优化，后边可能凑不出k个数字
        //这里的优化主要是每一轮递归要走的搜索上界，减掉不必要的搜索，可以结合题解中第二张树形图以及后边的说明来理解
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            // 向路径变量里添加一个数，在栈的尾巴添加，和add起到一个效果,例子中 n=4,k=2,头两轮递归中：path：1,2->1,3->1,4
            path.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 删除尾部元素，注意remove方法是删除头
            path.remove(path.size()-1);
        }
    }
}
