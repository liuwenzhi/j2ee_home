package lkhwtk.leetcode638;

import java.util.ArrayList;
import java.util.List;

/**
 * 638. 大礼包
 * 参考题解：官方
 * 题目说明：本题题干很不好理解，price列表是物品价格，needs列表是购物单，两个列表中的商品都是一一对应的，price价格列表中包括全部商品的价格，
 * needs列表是所需要物品，如果某件物品没有需求，对应数量为0，总之price列表中存储第i件商品价格，needs列表存储第i件商品数量，能够保证第i件
 * 商品的对应。special列表是大礼包集合，集合中的每个元素是具体每一个大礼包，大礼包中包括全部n件产品的数量，如果没有就是0，总之大礼包中包括
 * 了全部商品数量信息，最后第n+1个元素是这个大礼包的价格，三个列表中商品的信息是完全对应的。本题的难点在于：选择大礼包还是不选择大礼包，把各
 * 种方案进行比对，找到在不超过购买商品数量的情况下，如何达到花钱最少。从动态规划的解题思路来看，本题是扩展的完全背包问题，暂时先通过递归+回溯
 * 来解题。
 */
public class Solution {
    /**
     * 直接递归方式，效率较低，作为一个基础的解法理解后边的内容。
     *
     * @param price   每个物品的价格
     * @param special 大礼包数据
     * @param needs   待购物品清单
     * @return
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    /**
     * @param price
     * @param special
     * @param needs
     * @return 最少价格
     */
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        //没有使用大礼包的时候，我们须要花多少钱，注意：needs是递归传进来的列表，每次都会变，最开始是完整的needs列表
        //之后每一次递归，是去除大礼包的配置之后的值，res在每一次递归进来都需要重新计算一次
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        //针对于大礼包的每一种组合情况，都计算一遍花费，for循环外层遍历大礼包，内层遍历商品
        for (List<Integer> item : special) {
            //todo 注意列表克隆的实现方式
            List<Integer> clone = new ArrayList<>(needs);
            int j;
            for (j = 0; j < needs.size(); j++) {
                // 用我们须要的个数 - 大礼包里面的个数
                int diff = clone.get(j) - item.get(j);
                if (diff < 0) {
                    // 须要的 < 大礼包
                    break;
                }
                // 须要的部分越来越少，set 的意思是在做减法
                clone.set(j, diff);
            }

            //j走到了最后，即没有出现break的情况，递归执行下一次计算，大礼包能满足当前的需求
            if (j == needs.size()) {
                //注意：这里的item.get(j)容易误解，在Special列表中，最后一个元素是价格，这里的if已经验证了j==needs.size了，实际是走到了超过needs
                //列表，Special列表中当前item列表中的最后一个元素，为当前大礼包的价格
                res = Math.min(res, item.get(j) + dfs(price, special, clone));
            }
        }
        return res;
    }

}
