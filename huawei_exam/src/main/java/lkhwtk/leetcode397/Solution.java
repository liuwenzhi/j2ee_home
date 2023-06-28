package lkhwtk.leetcode397;

/**
 * 397. 整数替换
 * 参考题解：java 0ms 100% 时间O(logn) 空间O(1) 位运算
 * 本题读明白题之后梳理好基本思路不难，主要是本题有两个坑点，一个是3不是一般套路，还有整形最大值的处理
 * 本题属于固定算法，背一下思路
 */
public class Solution {
    public int integerReplacement(int n) {
        //count为走到1实际计算次数，循环的条件为n不为1
        int count = 0;
        while (n!=1){
            //与运算判断最后一位来区分奇偶，偶数末位一定是0,0&1==0
            if((n & 1) == 0){
                //偶数直接无符号右移，注意，整形最大值：2147483647 会被奇数处理算法加一溢出为负数，若选用带符号右移将无法回到1.
                n >>>=1;
                count++;
            }else {
                //识别奇数的上一位是否为1，即 以 01 结尾(xxxx01)还是以11结尾(xxxx11)
                if((n & 2) == 0){
                    //01结尾最优则应当 用 n -1 取代 n
                    n -= 1;
                    count++;
                }else {
                    //11结尾除3这个特殊情况外，其余选用 n + 1取代 n，原因如上
                    if(n == 3){
                        //3的特殊性处理，原因如上，3-2-1
                        count+=2;
                        break;
                    }else {
                        n += 1;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
