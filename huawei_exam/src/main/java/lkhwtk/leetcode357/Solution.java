package lkhwtk.leetcode357;

/**
 * 357. 计算各个位数不同的数字个数
 * 思路参考：数学知识解决此题
 * 数学知识：n=4的总数就等于9987加上n=3时的总数之和
 */
public class Solution {
    /**
     * 本题是一个基于数学规律的题目
     * 1位数字：0~9中各个位不重复的数字个数          10个， 因为是1位数，都不重复
     * 2位数字：10-99中各个位不重复的数组个数        81个，  9*9
     * 3位数字：100-999中各个位不重复的数字个数      648个， 9 * 9 * 8
     * 4位数字：1000-9999中各个位不重复的数字个数    4356个，9 * 9 * 8 * 7
     * ... ...
     * 最后，总数 = 上边统计的各个段的统计值之和
     * 本题中n应该是小于10的，不然10的10次幂超过了int的表示范围
     */
    public int countNumbersWithUniqueDigits(int n) {
        //0不涉及到具体规律内容，单独处理一下
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        if(n==2)
            return 91;
        int sum=9;
        int count=9;
        //注意：根据规律，n=4，4位数不重复的个数为9*9*8*7，之前已经定义了一个count=9，sum=9了，乘积数列中前两个数已经找到，for循环中实际循环n-1次，不是n次，
        for(int i=1;i<n;i++){
            sum*=count;
            count--;
        }
        return sum+countNumbersWithUniqueDigits(n-1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(4));
    }
}
