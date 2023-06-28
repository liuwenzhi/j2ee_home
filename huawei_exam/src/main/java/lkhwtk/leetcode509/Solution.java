package lkhwtk.leetcode509;

/**
 * 509. 斐波那契数
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
            answer = last+preToLast;
            preToLast = last;
            last = answer;
        }
        return answer;
    }
}
