package com.duomu.hj46;

import java.util.Scanner;

/**
 * 题目描述
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 * 输入描述:
 * 输入待截取的字符串及长度
 *
 * 输出描述:
 * 截取后的字符串
 *
 * 示例1
 * 输入
 * 我ABC汉DEF
 * 6
 * 输出
 * 我ABC
 */
public class Main {
    /**
     * 知识点补充：“一个汉字=2个英文字母=2字节
     * 官方标准: 1汉字=2字节 1字节(Byte)=8字位=8个二进制数
     * 1字位(bit)=1个二进制数 1B=8b 1KB=1024B 1MB=1024KB 1GB=1024MB 硬件商标准: 1GB=1000MB 1MB=1000KB 1KB=1000B...”
     * 判断是汉字
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //本题这么接收入参在线上会有问题
            /*String line = scanner.nextLine();
            int num = Integer.parseInt(scanner.nextLine());*/
            //需要这么接收，63题按照上边的方式没问题，这里可能有坑，注意下吧。
            String line = scanner.next();
            int num = scanner.nextInt();
            //记录最终截取字符串的位置
            int index = 0;
            for(int i=0;i<line.length();i++){
                if(isChineseByScript(line.charAt(i))){
                    num-=2;
                    if(num>=0){
                        index++;
                    }else{
                        break;
                    }
                }else{
                    //普通字符的情况
                    num-=1;
                    if(num>=0){
                        index++;
                    }else{
                        break;
                    }
                }
            }
            System.out.println(line.substring(0,index));
        }
    }

    /**
     * 判断一个字符是否是汉字，jdk7提供了UnicodeScript
     * 就得判断方法为通过ASCII码进行判断，判断是否c>128
     */
    private static boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }
}
