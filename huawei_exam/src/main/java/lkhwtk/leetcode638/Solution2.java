package lkhwtk.leetcode638;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考题解：递归java双百
 * 两个递归思路有些复杂，先重点参考官方题解
 */
public class Solution2 {

    private int min;

    public int shoppingOffers(List<Integer> price,List<List<Integer>> special,List<Integer> needs) {
        min = 0;
        //不使用大礼包的情况下，计算总共消费
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        dfs(price, special, 0, needs, min);
        return min;
    }

    private void dfs(List<Integer> price,List<List<Integer>> special,int start,List<Integer> needs, int money) {
        if (start >= special.size()) {
            return;
        }
        List<Integer> cur = special.get(start);
        boolean can = true;
        List<Integer> newNeeds = new ArrayList<>();
        int tmp = 0;
        for (int j = 0; j < cur.size() - 1; j++) {
            int size = cur.get(j);
            if (needs.get(j) < size) {
                // 不能选该礼包了
                can = false;
                break;
            }
            newNeeds.add(needs.get(j) - size);
            tmp += price.get(j) * size;
        }
        if (can) {
            // 可以选该礼包
            int newMoney = money - tmp + cur.get(cur.size() - 1);
            min = Math.min(min, newMoney);
            dfs(price, special, start, newNeeds,newMoney);
        }
        // 不选该礼包
        dfs(price, special, start + 1, needs, money);
    }

}
