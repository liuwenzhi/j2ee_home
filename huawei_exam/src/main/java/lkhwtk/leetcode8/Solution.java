package lkhwtk.leetcode8;

/**
 * 8. 字符串转换整数 (atoi)
 * 思路：去掉前导空格，判断第一个字符是+还是-，提取数字
 * java 整形范围：-2147483648 ~ +2147483647
 * 2021年9月8日三轮刷题对算法进行优化：主要是数字位字符转成数字，不是采用Integer.parseInt这种方式，直接用 字符-'0',时间效率提升3倍左右
 */
public class Solution {
    public int myAtoi(String s) {
        //数字正负标志，+ true，- false
        boolean flag = true;
        //最终数字
        int num = 0;
        //去掉前导空格
        int index = 0;
        while(index<s.length()&&s.charAt(index)==' '){
            index++;
        }
        //空字符串的情况，直接返回0
        if(index == s.length()){
            return 0;
        }
        //去掉前导空格之后再判断正负
        if(s.charAt(index)=='-'){
            flag = false;
            index++;
        }else if(s.charAt(index)=='+'){
            //去掉空格之后，可能会有正号，可能没有，还是要判断一下
            index++;
        }
        for(int i=index;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                //三轮复习优化点：s.charAt(i)-'0'
                if(flag&&(num>Integer.MAX_VALUE/10||num==Integer.MAX_VALUE/10&&(s.charAt(i)-'0')>Integer.MAX_VALUE%10)){
                    num = Integer.MAX_VALUE;
                    break;
                }else if(!flag&&num>Integer.MAX_VALUE/10||num==Integer.MAX_VALUE/10&&(s.charAt(i)-'0')>=8){
                    //这里已经标记为最负的一个数字，flag就不用再进行为负判断了,另外这里加了一步等于8，因为不能通过正数计算之后再转负数了
                    num = Integer.MIN_VALUE;
                    //如果是num赋值了Integer.MIN_VALUE，那么已经是负数了，不需要后边再*（-1）
                    flag = true;
                    break;
                }
                num = num*10+(s.charAt(i)-'0');
            }
            //如果读到字母或者其他符号就退出
            if(!Character.isDigit(s.charAt(i))){
                break;
            }
        }
        if(!flag){
            return num*(-1);
        }else{
            return num;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-43"));
        //-2147483648~2147483647
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("3.1415926"));
        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("+-12"));
        System.out.println(solution.myAtoi("00000-42a1234"));
        System.out.println(solution.myAtoi("2147483646"));
        System.out.println(solution.myAtoi("21474836460"));
        //System.out.println(Integer.MAX_VALUE);
    }
}
