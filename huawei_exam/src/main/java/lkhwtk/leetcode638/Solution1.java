package lkhwtk.leetcode638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 官方记忆化搜索思路
 * 对needs进行记忆化存储，避免重复计算，优化核心思路：
 * 对于搜索状态 shopping(price, special, needs)，无论它是从哪个前置状态递归得来的，
 * 只要 needs 列表的元素值相同（price 和 special 在递归时是不会变的，我们将其放入搜索状态仅仅是为了方便使用这些变量），
 * 那么返回的最小花费也相同。因此我们可以使用一个哈希映射（HashMap）存储每个 needs 对应的最小花费，
 * 当我们递归进入一个搜索状态时，如果该状态中的 needs 没有出现过，那么我们进行搜索，
 * 并在搜索结束时将结果存入哈希映射；如果该状态中的 needs 出现过，那么我们就省去了搜索，直接返回哈希映射中对应的最小花费即可
 */
public class Solution1 {

    /**注意这种map定义方式，key是list列表，value是对应的最小值*/
    private Map<List<Integer>, Integer> map = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        return dfs(price, special, needs);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        //solution1相对于solution的优化出发点在于，这里的两层循环，可能会导致在递归的过程中出现needs列表相同的情况
        for (List<Integer> s : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0) {
                    break;
                }
                clone.set(j, diff);
            }
            if (j == needs.size()) {
                res = Math.min(res, s.get(j) + dfs(price, special, clone));
            }
        }
        map.put(needs, res);
        return res;
    }

}
