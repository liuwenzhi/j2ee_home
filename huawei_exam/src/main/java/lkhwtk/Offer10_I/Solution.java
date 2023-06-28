package lkhwtk.Offer10_I;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 基于动态规划方式实现斐波那契数列
 * 本题多了一个对结果取模
 */
public class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int last = 1;
        int preToLast = 1;
        int answer = 0;
        for(int i=3;i<=n;i++){
            //本题涉及对结果取模，注意一定是在动态规划的过程中取模，不能在最后的结果取一个模
            answer = (last+preToLast)% 1000000007;
            preToLast = last;
            last = answer;
        }
        return answer;
    }
}
