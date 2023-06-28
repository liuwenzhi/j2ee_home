package lkhwtk.leetcode306;

/**
 * 306. 累加数
 * 参考题解：Java回溯（0ms，100%）
 * 本题暂时没有官方题解，这个题解采用递归思路非常难想出来，后边可以多看几遍，这个抽象非常复杂
 * 实际最核心的思路就是按照一个树型的结构，全部数字组合遍历一遍，看看能不能得到累加数序列
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        //初始的pre参数随便传一个就行，对后边没有影响
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * @param num    原始字符串
     * @param len    原始字符串长度
     * @param idx    当前处理下标
     * @param sum    前面的两个数字之和
     * @param pre    前一个数字
     * @param k      当前是处理的第几个数字
     * 递归算法中，重复执行了for循环内容，但是实际上，每一次递归，很大概率上没有把for都走完，走了其中几位，
     * 在递归过程中每一次进入for循环的时候，在拿到了cur==sum之后，就进入下一层递归，idx后移1位，到最后有
     * 返回值之后，一层一层直接返回。这个递归实际效率很低的，应该是测试用例没有大的数据量
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        //递归出口条件：当遍历完最后数组中一个元素之后，必须的是处理了超过2个数字，才能保证有前两数字之和等于第三个数字
        //基于算法的设计，不会出现到了最后一个元素之后，之前不满足累加的情况，能走进if判断里边，肯定是前边都满足条件了
        if (idx == len) {
            return k > 2;
        }
        for (int i = idx; i < len; i++) {
            //从字符串中截取当前数字，长度可能是1位，可能是多位
            long cur = fetchCurValue(num, idx, i);
            // 剪枝：无效数字，备注：数字可以是单独一个0
            /*if (cur < 0) {
                continue;
            }*///2021年8月30日二轮刷题确认这个剪枝完全没有必要
            // 剪枝：当前数字不等于前面两数之和的情况，如果continue直到len，都不等于，则当前递归层在最后返回false
            if (k >= 2 && cur != sum) {
                continue;
            }
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
                return true;
            }
        }
        //这个返回非常必要，不能少
        return false;
    }

    /**
     * 获取一个字符串num从左边l位置到右边r位置全部字符组成的合法数字
     */
    private long fetchCurValue(String num, int l, int r) {
        //注意：算法中入参的l和r可能是相等的，如果是l和r一左一右，同时左边以0开头，肯定不满足条件
        if (l < r && num.charAt(l) == '0') {
            return -1;
        }
        long res = 0;
        //注意左右位可能相等
        while (l <= r) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("1123581"));
    }

}
