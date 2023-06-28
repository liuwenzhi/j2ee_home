package lkhwtk.leetcode1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. 两地调度
 * 本题题目很长，不太好理解，就是有2n个人要面试，面试地点是a和b，2n个人中，
 * 到a地和b地两个地点的交通费用不一样，要求a地和b地都有n个人去面试，同时2n
 * 个人参加面试去a、b两地的交通费用要最少
 * 核心思路：贪心：先找到每个Cost中最小的，然后看下Costa和Costb哪个少，去找下平衡
 * 参考题解：官方，直接按照上边个人思路来想，很难处理，参考下官网给出的思路，换一个角度来使用贪心
 * 官方题解中说：如果选择改变一个人的行程，那么公司将会额外付出 price_A - price_B 的费用，这句话
 * 的意思是，人都往B去，一个人花费为price_B,然后要改变一个人的行程，去A，花费为price_A,这时候就涉
 * 及到一个变更的成本，变更成本是price_A-price_B，即额外消费，从B变到A，肯定是用price_A-price_B，
 * 体现出到A的费用的变化，本题经过这一步骤抽象之后，变成找额外费用最小的。如果额外费用是负数，则
 * 相当于省钱了，说明去A要比去B省钱，按照算法排序规则，省的越多，值越小，排序越靠前，这一点是算法
 * 设计的核心。
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //一种很好的排序思路：按照去A和B两地的费用差来排序，费用差可正可负，排序按照插值从小打大
        //按照main函数中的入参，排序之后是：{30,200}差值-170，{10,20}差值-10，{30,20}差值10，{400,50}差值350
        //这里不用想得太复杂，费用差可正可负，排序后，肯定是前N个去A地，后N个去B地
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int total = 0;
        int n = costs.length / 2;
        //按照上边差值排序好之后，前边n个走A城，后边n个走B城
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(solution.twoCitySchedCost(costs));
    }

}
