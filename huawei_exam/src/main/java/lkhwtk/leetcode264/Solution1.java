package lkhwtk.leetcode264;

/**
 * 按照算法判断质因子是否满足条件的方式还是会超时，能够跑完一半左右的用例
 * 2021年9月23日按照263题思路优化判断丑数，有三重循环降为两层循环，还是会超时，测试用例通过率：84%(500/596)
 */
public class Solution1 {
    public int nthUglyNumber(int n) {
        //1特殊处理一下
        if(n==1){
            return 1;
        }else{
            //题目已经给出n的范围是大于等于1，else分支直接看大于1的情况
            int index = 1;
            int num = 1;
            while (index < n) {
                num++;
                if (isPrimerFactors(num)) {
                    //查看
                    //System.out.println(num);
                    index++;
                }
            }
            return num;
        }
    }
    private boolean isPrimerFactors(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
