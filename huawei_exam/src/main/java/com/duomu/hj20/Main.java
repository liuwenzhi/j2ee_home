package com.duomu.hj20;

import java.util.Scanner;

/**
 * 题目描述
 * 密码要求:

 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度大于2的子串重复
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class Main {
    /**
     * 注意本地解题的关键点：如何验证第三点。不考虑一个字符，和两个字符的子串，
     * 判断不能有长度大于2的子串重复，就是验证不能有连续重复的3个字符就行了，
     * 因为如果有四个，五个重复的情况，那就肯定包括3个字符的子串重复了
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String password = scanner.nextLine();
            if(checkLength(password)&&checkCharacter(password)&&checkRepeat(password)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }

    /**验证字符串长度不能超过八位*/
    private static Boolean checkLength(String password){
        return password.length()>8?true:false;
    }

    /**验证字符*/
    private static Boolean checkCharacter(String password){
        boolean flag1=false,flag2=false,flag3=false,flag4=false;
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
                flag1 = true;
            }else if(password.charAt(i)>='A'&&password.charAt(i)<='Z'){
                flag2 = true;
            }else if(password.charAt(i)>='0'&&password.charAt(i)<='9'){
                flag3 = true;
            }else{
                //除了大小写字母和数字的其它字符的情况
                flag4 = true;
            }
        }
        int num = (flag1==true?1:0)+(flag2==true?1:0)+(flag3==true?1:0)+(flag4==true?1:0);
        if(num >=3){
            return true;
        }else{
            return false;
        }
    }

    /**验证不能有相同长度大于2的重复字符串,注意要考虑到一种特殊情况：
     * AAAA，其中AAA和AAA是不重复的*/
    private static Boolean checkRepeat(String password){
        for (int i = 0; i < password.length() - 3; i++) {
            //注意subString函数特点，传一个参数是从这个位置开始到结束，两个参数是从开始到结束，前包含，后不包含
            if (password.substring(i + 3).contains(password.substring(i, i + 3)))
                return false;
        }
        return true;
    }
}
