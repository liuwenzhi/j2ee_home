package lkhwtk.offer10_II;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 本题同主站70题，注意本题涉及到取模计算，需要在变量和answer的取值上都做出取模计算
 */
public class Solution {
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        //初始值
        int last = 1;
        int nextToLast = 1;
        int answer = 0;
        for(int i=1;i<n;i++){
            answer = (last + nextToLast)%1000000007;
            //nextToLast = last%1000000007;
            nextToLast = last;
            //last = answer%1000000007;
            last = answer;
        }
        return answer;

    }
}
