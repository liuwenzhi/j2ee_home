package lkhwtk.leetcode70;

/**
 * 思路2：动态规划
 * 状态转移方程：f(x)=f(x-1)+f(x-2)
 * f(x)代表走到第x层的方案数，因为f(x)只和它的前两个元素关联，所以用last代替f(x-1),nextToLast代替f(x-2)
 * offer10-II和本题思路相同
 */
public class Solution1 {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        //初始值
        int last = 1;
        int nextToLast = 1;
        int answer = 0;
        //注意：循环从1开始，如果n=2，循环一次，last代表走到第1层的方案数，nextToLast代表走到第0层的方案数，走到0层的方案数+走到1层的方案数就是2
        for(int i=1;i<n;i++){
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.climbStairs(2));
    }
}
