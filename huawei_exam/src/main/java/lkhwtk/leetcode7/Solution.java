package lkhwtk.leetcode7;

/**
 * 7. 整数反转
 * 参考题解：图解 7. 整数反转
 * 本题要反转的字符串是带有符号的，使用数学的方式计算更快
 * 注意对边界情况的处理，不能超过整数表示范围，注意：32位有符号整数的表示范围：[-2的31次幂,2的31次幂-1]
 * 2的31次幂-1 = 2147483647 备注：有符号数32为中留最高位为符号位，数字位一共31位
 * -2的31次幂 = -2147483648 备注：别忘了采用补码的方式可以表示出最负的一位数
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int tmp = 0;
        //注意：不要直接用整数的边界进行判断，可能会有问题，而且本题的情况是可能入肯定参满足整形范围，但是翻转后不满足条件比如：1147483649
        /*if(x > 2147483647 || x < -2147483648){
            return 0;
        }*/
        while(x!=0){
            tmp = x%10;
            if(result > 214748364 || result == 214748364 && tmp > 7){
                //重点：判断当循环进入到x的1/10时，是否会超出有符号正整数上限
                return 0;
            }
            if(result < -214748364 || result == -214748364 && tmp < -8){
                //重点：判断当循环进入到x的1/10时，是否会超出有符号数下限
                return 0;
            }
            result = result*10+tmp;
            x = x/10;
        }
        //如果x是0则直接返回
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
        //12300反转后是321
        System.out.println(solution.reverse(12300));
    }
}
