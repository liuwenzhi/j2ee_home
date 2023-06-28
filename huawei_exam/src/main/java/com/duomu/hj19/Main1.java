package com.duomu.hj19;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 个人删除map集合对象的思路，超过8条就删除，这种方式只能跑完一半的用例，
 * 还是以Main为主，LinkedHashMap获取并删除头元素的方法后边用到了可参考下：map.remove(map.entrySet().iterator().next().getKey());
 */
public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            //从输入中按照空格截取文件路径和名称
            String s[] = line.split("\\s+");
            //直接提取文件名称，去掉路径
            String fileName = s[0].substring(s[0].lastIndexOf("\\")+1);
            //从截取的文件路径和名称信息中，再截取16位文件名称信息
            if(fileName.length()>16){
                //从fileName.length()-16开始截取，相当于截取16个字符，substring输入一个参数相当于从这个位置开始截取一直截取到末尾
                fileName = fileName.substring(fileName.length()-16);
            }
            //设置存储到map中的key为文件名称+空格+行号
            String key = fileName+" "+s[1];
            if(!map.containsKey(key)){
                map.put(key,1);
                if(map.size()>8){
                    //map长度大于8的时候，删除头结点
                    map.remove(map.entrySet().iterator().next().getKey());
                }

            }else{
                map.put(key,map.get(key)+1);
            }
        }
        /*注意：本题是在while循环之外做输出，本地测试时可以通过在输入的下一行输入ctrl+d组合键
        (可能需要关闭输入法)实现退出scanner这个判断循环，得到结果输出*/
        for(Map.Entry<String,Integer> it:map.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
    }
}
