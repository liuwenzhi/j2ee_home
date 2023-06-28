package lkhwtk.leetcode781;

import java.util.HashMap;
import java.util.Map;

/**
 * 781. 森林中的兔子
 * 参考题解：官方
 * 本题比较绕，是一个偏数学推理类问题，直接参考官方给出题解即可。
 * 下边高赞的回答：宫水三叶，负雪明烛，里边给出了完整的推理证明，这个如果以后有需求再看，直接通过官方找规律得出结论即可。
 * 贪心算法的核心思路：假设兔子说的同类颜色数量在入参数组中，数量大的都在数组中，这样能保证额外的兔子数量最少
 */
public class Solution {
    public int numRabbits(int[] answers) {
        //map集合的key是入参数组中相同元素值的个数，也就是回答同色个数相同的这些数字，value是对应相同的这些数字有几个
        Map<Integer, Integer> count = new HashMap<>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        //遍历一个map集合，key和value都用到用entry来处理
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            //相对于题解中的内容，这里做了一个向上取整
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;

    }
}
