package lkhwtk.leetcode254;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. 因子的组合
 * 因子和质因子相关内容参考hj6和hj56
 * 参考题解：java版本 dfs+剪枝
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        //找整数的因子一定是从2开始
        return dfs(2,n);
    }

    List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        //遍历集合上限是根号num，没有必要遍历num全部数值，本题涉及到一定数学理论
        int qNum = (int)Math.sqrt(num);
        List<List<Integer>> result = new ArrayList<>();
        //初始是2，每一次递归从num/mulNum往后走，上限是num开根号，这么设置上限除了减少计算量还能避免重复，比如32，前边有了一个2*16，后边又来了一个16*2
        for (int mulNum = start; mulNum <= qNum;mulNum++) {
            if (num % mulNum == 0) {
                //mulNum * num/mulNum = num，先把当前的拆分结果放到列表中，并把这个列表放到最终结果列表中
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(mulNum);
                simpleList.add(num/mulNum);
                result.add(simpleList);
                //检查mulNum能怎么拆，mulNum * num/mulNum = num，再拆：num/mulNum，一步一步递归走下去，然后每一次nextList再和当前的mulNum合并
                List<List<Integer>> nextLists = dfs(mulNum, num/mulNum);
                //遍历拉去到的结果，一个一个放到result结果集合中
                for (List<Integer> list : nextLists) {
                    list.add(mulNum);
                    result.add(list);
                }
            }
        }
        return result;
    }

}
