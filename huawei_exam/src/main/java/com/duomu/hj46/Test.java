package com.duomu.hj46;

/**
 * 注意一个知识点：substring方法中两个参数，第一个是截取字符串开始位置（从0开始），
 * 第二个是截取多长，如果没有第二个参数，那么就会截取到字符串最后一个位置
 */
public class Test {
    public static void main(String[] args){
        String s = "我ABC汉DEF";
        System.out.println(s.substring(0,2));
    }
}
