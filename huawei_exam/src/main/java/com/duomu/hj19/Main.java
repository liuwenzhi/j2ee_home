package com.duomu.hj19;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 * 处理：
 *
 *
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是”相同“的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 *
 * 输入描述：
 * 每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述：
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 */
public class Main {
    /**
     * 使用LinkedHashMap能保证按照输入的顺序进行输出，HashMap无顺序，TreeMap会按照key进行排序，只能使用LinkedHashMap
     * 本算法中，并没有实际去删除LinkedhashMap中的日志记录，最后输出了8条
     */
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
            Integer value = map.get(key);
            if(value==null){
                map.put(key,1);
            }else{
                map.put(key,value+1);
            }
        }
        /*注意：本题是在while循环之外做输出，本地测试时可以通过在输入的下一行输入ctrl+d组合键
        (可能需要关闭输入法)实现退出scanner这个判断循环，得到结果输出*/
        int i=0;
        for(Map.Entry<String,Integer> it:map.entrySet()){
            //注意这里的设计，只有当i进入最后八条记录时，才做输出，这个地方有点容易乱，比如按照样例中给的日志内容，
            //map最终大小是9，其中有一条记录重复，那么i=0，不显示，i=1显示日志，i=2显示日志...i=8显示日志，当i=9的时候，
            //Map已经遍历完了，不会再进入循环，map.size()-i<=8实际是保证i=1时能正常显示日志，如果是<8会丢了i=1时候的日志
            if(map.size()-i<=8){
                System.out.println(it.getKey()+" "+it.getValue());
            }
            i++;
        }
    }
}
