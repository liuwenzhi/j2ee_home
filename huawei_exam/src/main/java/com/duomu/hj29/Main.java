package com.duomu.hj29;

import java.util.Scanner;
/**
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 * 2加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * 接口描述：
 *     实现接口，每个接口实现1个基本操作：
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * 示例1
 * 输入
 * abcdefg
 * BCDEFGH
 * 输出
 * BCDEFGH
 * abcdefg
 */
public class Main {
    /**
     * 备注：小写字母ASCII码：97~122，大写字母ASCII码：65~90
     * 0到9字符的ASCII码：48~57
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //要加密的字符串
            String line1 = scanner.nextLine();
            //要解密的字符串
            String line2 = scanner.nextLine();
            System.out.println(encrypt(line1));
            System.out.println(unEncrypt(line2));
        }
        scanner.close();
    }
    /**
     * 字符串加密方法
     */
    private static String encrypt(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                if(str.charAt(i)=='z'){
                    sb.append('A');
                }else if(str.charAt(i)=='Z'){
                    sb.append('a');
                }else{
                    //小写字母转大写
                    if(Character.isLowerCase(str.charAt(i))){
                        sb.append(Character.toUpperCase((char)(str.charAt(i)+1)));
                    }else{
                        //大写字母转小写
                        sb.append(Character.toLowerCase((char)(str.charAt(i)+1)));
                    }
                }
            }else if(Character.isDigit(str.charAt(i))){
                if(str.charAt(i)=='9'){
                    sb.append('0');
                }else{
                    sb.append((char)(str.charAt(i)+1));
                }
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 字符串解密方法
     */
    private static String unEncrypt(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                if(str.charAt(i)=='A'){
                    sb.append('z');
                }else if(str.charAt(i)=='a'){
                    sb.append('Z');
                }else{
                    //小写字母转大写
                    if(Character.isLowerCase(str.charAt(i))){
                        sb.append(Character.toUpperCase((char)(str.charAt(i)-1)));
                    }else{
                        //大写字母转小写
                        sb.append(Character.toLowerCase((char)(str.charAt(i)-1)));
                    }
                }
            }else if(Character.isDigit(str.charAt(i))){
                if(str.charAt(i)=='0'){
                    sb.append('9');
                }else{
                    sb.append((char)(str.charAt(i)-1));
                }
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

