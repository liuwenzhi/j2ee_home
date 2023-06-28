package lkhwtk.leetcode464;

/**
 * 464. 我能赢吗
 * 参考题解：回溯，状压DP
 * 题解中的回溯算法会超时，重点参考状压DP，状压DP和下边这个知乎上的题解一致
 * 知乎参考题解：https://zhuanlan.zhihu.com/p/340063230，知乎上的题解对本题说明很详细，包括状压DP的概念。其中len的实现实际在算法中用不到。
 * 本题主要难点在于：可选的数字不能重复，所以一个固定集合中的数字，哪些能选，哪些不能选，需要在每一次递归中确认，
 * 同时还能够在回溯中正确返回，如果存set，成本极高。用状态压缩码来模拟非常适合，然后就是如果通过状态压缩码来模拟
 */
public class Solution {
    /**
     * @Description:
     * 由于状态不可用数组进行传递【在递归当中会受到改变，不能准确定位当前状态】，故在此处用Int的位表示状态（1表示用过,0表示未用过）
     * 这里采用DP状态压缩的方式，思想与回溯类似，只是这里的状态被压缩成了一个bitArray了
     * 状态压缩，我们可以用二进制的第i位的0或者1来表示i这个数字的选取与否，这样所有数字的选取状态就可以用一个数来很方便的表示，
     * 题目说了不超过20位(不超过20)，所以这里就可以用一个int来表示状态state，通过state来判断状态是否一致，进而进行记忆化的存取
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        //如果最大可选值比目标值大或等，则先出手的玩家一定能赢，直接选目标值就行了
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        //等差数列求和公式，1,..maxChoosable数列总和都比目标和小，此时谁都无法赢
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        /**
         *  dp表示"每个"取数(A和B共同作用的结果)状态下的输赢
         *  例如只有1,2两个数选择，那么 (1 << 2) - 1 = 4 - 1 = 3种状态表示：
         *  01,10,11分别表示：A和B已经选了1，已经选了2，已经选了1、2状态下，A的输赢情况
         *  并且可见这个表示所有状态的dp数组的每个状态元素的长度为maxChoosableInteger位的二进制数
         *  注意：这里初始化dp数组采用Boolean的方式，不是boolean，初始化之后值都是null，可以看下main函数中运行结果
         */
        Boolean[] dp = new Boolean[(1 << maxChoosableInteger) - 1];//1左移maxChoosableInteger位，相当于2的maxChoosableInteger次幂-1，实际相当于每一位取或者不取，然后把都不取这种情况去掉
        //注意state，状态压缩主要是处理它，初始的时候给一个0，一个数字都没选
        return dfs(maxChoosableInteger, desiredTotal, 0, dp);
    }

    /**
     * @param maxChoosableInteger 选择的数的范围[1,2,...maxChoosableInteger]
     * @param desiredTotal 目标和
     * @param state 当前状态的十进制表示（记录着可能不止一个数被选择的状态）
     * @param dp 记录所有状态
     * @return
     */
    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
        //递归方法出口，通过Boolean方式初始化的数组初始值为null
        if (dp[state] != null) {
            return dp[state];
        }
        /**
         * for循环模拟取集合中取具体的数字
         * 例如maxChoosableInteger=2，选择的数只有1,2两个，二进制只要两位就可以表示他们的选择状态
         * 最大位为2（第2位），也就是1 << (2 - 1)的结果，所以最大的位可以表示为  1 << (maxChoosableInteger - 1)
         * 最小的位可以表示为 1 << (1 - 1)，也就是1（第1位）
         * for循环中i表示括号的范围，从1到最大可选值maxChoosableInteger
         */
        for (int i = 1; i <= maxChoosableInteger; i++){
            //获取当前待抉择的位，实际上是拿到一个类似state的压缩状态值，第一次循环的时候，state是0，tmp是1，此时state代表还没有使用的数字，tmp代表要使用第一位
            int tmp = (1 << (i - 1));
            /**
             * 获取tmp后判断用以表示该位（数字）的是否被使用过
             * 直接和入参state做与操作，结果为0代表这个位没有被使用过
             */
            if ((tmp & state) == 0){  //该位没有被使用过
                //如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了,tmp|state表示进行状态的更新，在状态位上增加当前位的使用
                /**
                 * 例如
                 *  100
                 * |011
                 * =111
                 */
                //注意这里并没有像回溯一样进行状态的(赋值化的)更新、回溯，其实这里是隐含了回溯的，我们通过参数传递更新后的state
                //但是我们在这个调用者这里的state还是没有进行更新的，所以就相当于回溯了状态。
                //注意：最先达到或者超过目标值，所以获胜的条件之一是desiredTotal - i <= 0
                //动态规划的核心在这里：要么先出手已经赢了，要么虽然先出手没赢，但是后出手输了。
                if (desiredTotal - i <= 0 || !dfs(maxChoosableInteger, desiredTotal - i, tmp|state, dp)) {
                    dp[state] = true;
                    return true;
                }
            }
        }
        //如果都赢不了
        dp[state] = false;
        return false;
    }

    public static void main(String[] args){
        /*KthLargest solution = new KthLargest();
        boolean[] b = new boolean[10];
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        Boolean[] bb = new Boolean[10];
        for(int i=0;i<bb.length;i++){
            System.out.println(bb[i]);
        }*/
        System.out.println((3 << 1) - 1);
    }

}
