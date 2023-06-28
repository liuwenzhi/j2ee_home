package lkhwtk.leetcode1702;

/**
 * 1702. 修改后的最大二进制字符串
 * 参考题解：【修改后的最大二进制字符串】数数
 * 代码参考题解：Java 一次遍历实现
 * 本题属于一道数学类归纳题目
 */
public class Solution {
    public String maximumBinaryString(String binary) {
        int length = binary.length();
        int i = 0;
        //第一步：左侧连续的1不动，找到第一个0出现的位置，最后就是i，这个位置前边的1都不动
        for(;i<length;i++){
            if(binary.charAt(i)=='0'){
                break;
            }
        }
        //如果入参binary字符串都是1，则直接返回这个最大值
        if(i==length){
            return binary;
        }
        //第二步：确认最后一个0出现的位置
        //在第一个0之后，找到还有几个0，这个思路是基于10都可以转成01，所以1是可以往右移动的，总之前边统计好了第一个0之前有几个1之后
        //从第一个0开始，可以把后边的1都移动到最右边，然后形成左边若干个1，右边若干个1，中间若干个0的情况，如果中间有n个0，根据00变10
        //可以把前n-1个0都变成1，这样就能形成最大数
        int zeroLeft = i,count=0;
        for(;i<length;i++){
            //统计后边0的数量
            if(binary.charAt(i)=='0'){
                count++;
            }
        }
        //算法走到这里能确认从第zeroLeft位开始，包括这一位在内，出现了几个0，那么可以确认，最终结果的0的位置是zeroLeft+count-1
        int zero = zeroLeft+count-1;
        //定义一个结果变量，在找到的0位上拼上0，其他位都拼上1
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=0;j<length;j++){
            if(j==zero){
                stringBuilder.append("0");
            }else {
                stringBuilder.append("1");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maximumBinaryString("0"));
    }
}
