package com.duomu.hj66;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入描述:
 * 多行字符串，每行字符串一条命令
 *
 * 输出描述:
 * 执行结果，每条命令输出一行
 *
 * 示例1
 * 输入
 * 复制
 * reset
 * reset board
 * board add
 * board delet
 * reboot backplane
 * backplane abort
 * 输出
 * 复制
 * reset what
 * board fault
 * where to add
 * no board at all
 * impossible
 * install first
 */
public class Main {
    /**
     * 核心思路：基于本题的规则，将6条配置命令分成两大类，四种情况。两大类是一个关键字和两个关键字：
     * 一个关键字命令：reset，两个关键字命令：其他五个
     * 其他五个两关键字命令可以再分出来3种情况：
     * r b匹配的命令：2个
     * b d匹配的命令：1个
     * b a匹配的命令：2个
     * 一个技巧：看看输入能不能和已有的命令匹配上，比如res能不能和reset匹配上，直接从reset字符串里边截取res长度的子串（从0开始截取），然后看看和res是否能与之匹配上
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        String[] command={"reset","reset board","board add","board delete","reboot backplane","backplane abort"};
        while((line=br.readLine())!=null){
            String[] str = line.split(" ");
            //如果命令中只有一个关键词，根据规则第一点和第二点，直接看能不能匹配reset
            if(str.length==1){
                //直接从reset这个字符串里边提取str[0]长度的子串，看看能不能和str[0]匹配上
                if(!str[0].equals(command[0].substring(0,str[0].length()))){
                    System.out.println("unknown command");
                }else {
                    System.out.println("reset what");
                }
            }else if(str.length==2){
                //输入两个关键字，并且第一关键字以r开头
                if(str[0].charAt(0)=='r'){
                    //如果输入是r b或者re b，则匹配结果不唯一，不用单独拿出来，后边能搞定
                    /*if((str[0].equals("r")&&str[1].equals("b"))||(str[0].equals("re")&&str[1].equals("b"))) {
                        System.out.println("unknown command");
                    }else */
                    if(str[0].length()<6 && str[1].length()<6 && str[0].equals(command[1].substring(0,str[0].length()))&&str[1].equals(command[1].substring(6,6+str[1].length()))) {
                        //匹配reset board命令的情况，条件判断中，首先是两个关键字的长度要在1到5之间，包括1到5，同时command[1]中两个关键字按照各自输入关键字的长度要能和输入关键字匹配上
                        System.out.println("board fault");
                    }else if(str[0].length()<7 && str[1].length()<10 && str[0].equals(command[4].substring(0,str[0].length()))&&str[1].equals(command[4].substring(7,7+str[1].length()))) {
                        //匹配reboot backplane的情况，条件判断中，首先是两个关键字的长度要在1到7之间，包括1到6，同时command[1]中两个关键字按照各自输入关键字的长度要能和输入关键字匹配上
                        System.out.println("impossible");
                    }else{
                        System.out.println("unknown command");
                    }
                } else if(str[0].charAt(0)=='b'){//输入两个关键字并且第一关键字以b开头
                    /*if((str[0].equals("b")&&str[1].equals("a"))) {
                        //如果输入是b a，则匹配结不唯一，不用单独拿出来，后边能搞定
                        System.out.println("unknown command");
                    }else */
                    if(str[0].length()<6 && str[1].length()<4 && str[0].equals(command[2].substring(0,str[0].length()))&&str[1].equals(command[2].substring(6,6+str[1].length()))) {
                        //匹配board add的情况
                        System.out.println("where to add");
                    }else if(str[0].length()<6 && str[1].length()<7 && str[0].equals(command[3].substring(0,str[0].length()))&&str[1].equals(command[3].substring(6,6+str[1].length()))) {
                        //匹配board delete
                        System.out.println("no board at all");
                    }
                    else if(str[0].length()<10 && str[1].length()<6 && str[0].equals(command[5].substring(0,str[0].length()))&&str[1].equals(command[5].substring(10,10+str[1].length()))) {
                        //匹配backplane abort
                        System.out.println("install first");
                    }
                }else {
                    System.out.println("unknown command");
                }
            }
        }
    }
}

