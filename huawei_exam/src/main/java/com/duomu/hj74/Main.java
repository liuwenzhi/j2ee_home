package com.duomu.hj74;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 题目描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\ d:\，
 *
 * 各个参数如下：
 *
 * 参数1：命令字xcopy
 *
 * 参数2：字符串/s
 *
 * 参数3：字符串c:\
 *
 * 参数4: 字符串d:\
 *
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 * 解析规则：
 *
 * 1.参数分隔符为空格
 * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
 * 3.参数不定长
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 输出参数个数，分解后的参数，每个参数都独占一行
 *
 * 示例1
 * 输入
 * 复制
 * xcopy /s c:\\ d:\\
 * 输出
 * 复制
 * 4
 * xcopy
 * /s
 * c:\\
 * d:\\
 */
public class Main {
    /**硬做细节太多，不推荐这么搞74题Main1的做法更具技巧*/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            getParameter(line);
        }
        scanner.close();
    }
    private static void getParameter(String line){
        boolean flag = false;
        String temp = "";
        int num = 0;
        List<String> list = new ArrayList<>();
        for(int i=0;i<line.length();){
            if("\"".equals(line.charAt(i)+"")){
                flag = !flag;
                if(temp!=""){
                    num++;
                    list.add(temp);
                    temp = "";
                    //结束引号后边肯定有空格，这时候走两步，这里走一步，if外再走一步
                    i++;
                }
                i++;
                continue;
            }
            if(flag){
                temp+=line.charAt(i);
                i++;
            }else{
                if(!" ".equals(line.charAt(i)+"")){
                    temp+=line.charAt(i);
                }else{
                    num++;
                    list.add(temp);
                    temp = "";
                }
                i++;
            }
        }
        //补上循环最后一次输出
        num++;
        System.out.println(num);
        list.forEach(t->{
            System.out.println(t);
        });
        System.out.println(temp);
    }
}
