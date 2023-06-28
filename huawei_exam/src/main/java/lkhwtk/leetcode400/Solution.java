package lkhwtk.leetcode400;

/**
 * 400. 第 N 位数字
 * 参考题解：详解 找规律
 */
public class Solution {
    public int findNthDigit(int n) {
        long num=n;
        //size为第n个数所在的数字是几位数
        long size=1;
        long max=9;
        while(n>0){
            //判断不在当前位数内，拿到具体size位数之后进入else
            if(num-max*size>0){
                num=num-max*size;
                size++;
                max=max*10;
            }else{
                //比如拿到size结果是3，num是具体三位数中的第多少个数字，Math.pow(10, size-1)+count 就能统计出目标数所在的数字
                long count=num/size;
                //left拿到目标数字是所在实际数字的第几个数字
                long left=num%size;
                if(left==0){
                    //如果left是0，则拿到的是目标数字前一个数字的最后一位
                    return (int) (((long)Math.pow(10, size-1)+count-1)%10);
                }else{
                    //如果left>0，则正常取目标数字的第i位
                    return (int) (((long)Math.pow(10, size-1)+count)/((long)Math.pow(10, (size-left)))%10);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(363));
    }
}
