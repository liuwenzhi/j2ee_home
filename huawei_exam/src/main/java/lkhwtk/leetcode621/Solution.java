package lkhwtk.leetcode621;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * 注意：本题开始有一个点一直没理解，读了半个多小时才理解，
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 * 两个相同的任务之间必须间隔长度为2的冷却时间，不光是指直接相邻的两个任务，是指两个相同类型的任务之间可能相邻，也可能不相邻，
 * 必须要间隔长度为2的冷却时间。所以这里A->B，如果再到B需要2个单位冷却时间，如果再到A，和上一个A之间已经有了一个B了，那么再待命
 * 一个时间间隔，就和上一个A的间隔满足了长度为2的冷却时间。
 * 思路参考：简明易懂的Java解答，使用贪心算法来求解
 * 针对于核心题解下中的补充内容，可以参考tasks = ["A","A","A","B","B","B","C","C","D","D"], n = 2，这个任务类型，此时任务种类很多
 * 不需要冷却时间，按照题解上中的方框图，可以写成
 * ABC
 * ABD
 * ABCD
 * 这个时候按照公式算会小，直接统计任务长度就可以了。
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        //模拟一个26位英文字母数组
        int[] buckets = new int[26];
        for(int i = 0; i < tasks.length; i++){
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);
        //取出现次数最多的任务执行次数
        int maxTimes = buckets[25];
        //出现次数和最大任务数量一致的任务
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        //注意：上述公式在n没有实际生效的时候，会得到一个不正确且偏小的结果，比如n==0或者这种
        // ["A","A","A","B","B","B", "C","C","C", "D", "D", "E"] 2，任务种类很多，n没有最终生效，n不生效的情况可以直接返回数组长度
        return Math.max(res, tasks.length);
    }
}
