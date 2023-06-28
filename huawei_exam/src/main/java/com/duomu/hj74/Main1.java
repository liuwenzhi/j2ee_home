package com.duomu.hj74;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 74题参考这个思路来处理，重点一个地方，根据 " 来拆分字符串，数组中奇数编号为字符串中元素
 * 偶数编号为字符串外数据，如果 " 在一个字符串的开头，那么split拆出来的数组0号元素是一个空
 * 字符串，具体验证方式参考Test
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            getParameter(line);
        }
        scanner.close();
    }
    private static void getParameter(String line){
        //根据单个引号将字符串拆分成字符串数组，然后按照拆分数组中的奇数和偶数编号来分别处理
        String[] temp = line.split("\"");
        List<String> list = new ArrayList<>();
        for(int i=0;i<temp.length;i++){
            if(i%2==1){
                //数组中奇数编号的元素为引号中间的元素
                list.add(temp[i]);
            }else{
                //数组中偶数编号的元素为非引号中的数据，可能为空格（连续两个引号包起来的字符串）
                if(!" ".equals(temp[i])){
                    //引号外边的字符串再单独进行拆分
                    String[] cache = temp[i].trim().split("\\s+");
                    for (String s : cache) {
                        list.add(s);
                    }
                }
            }
        }
        System.out.println(list.size());
        list.forEach(e->{
            System.out.println(e);
        });
    }
}