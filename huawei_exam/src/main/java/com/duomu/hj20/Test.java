package com.duomu.hj20;

public class Test {
    public static void main(String[] args){
        String s = "0123456789";
        //从第5位开始截取，一直到末尾
        System.out.println(s.substring(5));
        //从第二位截取到第五位，前包含后不包含
        System.out.println(s.substring(2,5));
        //判断一个字符是否是数字
        System.out.println(Character.isDigit('3'));
        //判断一个字符是否是字母
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetter('A'));

    }
}
