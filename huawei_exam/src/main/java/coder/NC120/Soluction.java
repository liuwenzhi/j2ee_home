package coder.NC120;

/**
 * NC120 二进制中1的个数
 * 这个思路正负数通吃，记一下
 */
public class Soluction {
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
