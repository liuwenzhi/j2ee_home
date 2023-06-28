package lkhwtk.leetcode338;

/**
 * 338. 比特位计数
 * 参考华为机试15题，之前之江实验室考了一道类似题目，位移效率相对不高
 */
public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++){
            result[i] = countNum(i);
        }
        return result;
    }

    private int countNum(int num){
        StringBuilder sb=new StringBuilder();
        for(int i=31;i>=0;i--){
            //无符号右移，int类型一共占4个字节，左移31位开始一直到移动0位，从最高位到最低位都和1做一遍与计算
            sb.append((num>>>i)&1);
        }
        //拿到转换的二进制数字
        String line=sb.toString();
        //System.out.println(line);
        //转成二进制数字之后统计1的个数，通过替换1为空字符串，然后计算字符串和原始字符串长度差
        return line.length()-line.replaceAll("1","").length();
    }
}
