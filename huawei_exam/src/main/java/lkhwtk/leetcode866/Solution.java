package lkhwtk.leetcode866;

/**
 * 866. 回文素数
 * 参考题解：官方，方法二：数学法
 * 核心思路：遍历所有数字，检查是不是回文串。如果是，检查是不是素数，如果当前数字长度为 8，可以跳过检查，因为不存在 8 长度的素数。
 * 这个结论记一下
 */
public class Solution {
    public int primePalindrome(int N) {
        //题目说一定能找到，这里直接使用while ture循环了
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            //如果数字长度为8位，可以直接跳过检查，长整数这个写法很棒，后边注意下
            if (10_000_000 < N && N < 100_000_000) {
                N = 100_000_000;
            }
            //这步优化还可以更进一步，100_000_000本身不是素数也不是回文数
            /*if (10_000_000 < N && N < 100_000_001) {
                N = 100_000_001;
            }*/
        }
    }

    /**
     * 判断是否是素数
     */
    /*public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }*/

    //判断是否是素数方法2，效率比方法1低一点
    /*private boolean isPrime(int num){
        // 一般从2找到n/2，判断是否能被整除。从5开始，n/2>√n，这样可以减少运算量。
        if(num <= 5) {
            return num == 2 || num == 3 || num == 5;
        }

        // 从2找到√num
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }*/

    //判断是否是素数方法3，效率略高于方法1
    public boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断是否是回文数，直接去一个数字的反转，然后再判断是否和原数相等
     */
    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }

}
