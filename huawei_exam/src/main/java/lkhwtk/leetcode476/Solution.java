package lkhwtk.leetcode476;

/**
 * 476. 数字的补数
 * 参考题解：抑或
 * 5的二进制是：0101，7的二进制是： 0111，它们的抑或为：0010，去掉前导零位即为取反。
 * 再来一个例子，假设a为1110 0101，b为1111 1111，a^b = 0001 1010是a的取反。也就是说二进制位数与num相同，且全为1的数tmp与num的抑或即为所求。
 * 算法背一下
 */
public class Solution {
    public int findComplement(int num) {
        int tmp = 1;
        while (tmp < num)
        {
            //1,3,7,15,tmp是全1二进制数字，最高位的1和num最高位的1在一个数位
            tmp <<= 1;
            tmp += 1;
        }
        return (tmp^num);
    }

    public static void main(String[] args){
        //Solution solution = new Solution();
        //System.out.println(solution.findComplement(5));

    }
}
