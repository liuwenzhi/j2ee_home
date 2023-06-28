package com.duomu.hj21;

import java.util.Scanner;

/**
 * 题目描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 *
 *
 *
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 *
 *
 *
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 *
 *
 *
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 *
 *
 * 输入描述:
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 *
 * 输出描述:
 * 输出渊子真正的密文
 *
 * 示例1
 * 输入
 * YUANzhi1987
 * 输出
 * zvbo9441987
 * 备注：leetcode17题和本题采用了类似的思路，通过map集合静态初始化手机上字母和数字的对应关系
 */
public class Main {
    /**
     * 题干的描述有点让人费解，实际就是表达了：原始密文是zvbo9441987，明文：YUANzhi1987通过题干中的算法可以变成这个原始密文。
     * 现在给一个明文，去按照题干中的算法求密文。变换的算法是从明文变成密文，即：从 YUANzhi1987 变到 zvbo9441987。
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String result = "";
            for(int i=0;i<line.length();i++){
                if(Character.isUpperCase(line.charAt(i))){
                    //明文中大写字母转小写后后移一位，大写的Z单独处理一下
                    if(line.charAt(i)=='Z'){
                        result += 'a';
                    }else{
                        result += Character.toLowerCase((char)(line.charAt(i)+1));
                    }
                }else if(Character.isLowerCase(line.charAt(i))){
                    //明文中小写字母转对应手机上的数字
                    result += wordToNum(line.charAt(i));
                }else{
                    //数字和其它符号不做变换
                    result += line.charAt(i);
                }
            }
            System.out.println(result);
        }
    }
    /*小写字母按照手机屏显示转成数字*/
    private static char wordToNum(char a){
        char result = 0;
        switch(a){
            case 'a':
            case 'b':
            case 'c':
                result = '2';
                break;
            case 'd':
            case 'e':
            case 'f':
                result = '3';
                break;
            case 'g':
            case 'h':
            case 'i':
                result = '4';
                break;
            case 'j':
            case 'k':
            case 'l':
                result = '5';
                break;
            case 'm':
            case 'n':
            case 'o':
                result = '6';
                break;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                result = '7';
                break;
            case 't':
            case 'u':
            case 'v':
                result = '8';
                break;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                result = '9';
                break;
        }
        return result;
    }
}
