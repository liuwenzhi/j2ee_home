package xysj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 兴业数金机考题目，对入参进行排序，
 * 入参样例： 5 1 7 2 3 4 10
 * 输出要求： 1 10 2 3 4 5 7
 * 入参样例： this is my book
 * 输出要求： book is my this
 * 本题开始看错了，以为是hj13题，按照hj13题的思路能跑完1/3的用例
 * 本题不能去重，没有使用TreeSet
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            List<String> list = new ArrayList<>();
            //注意空格正则表达式形式，本题直接用空格拆分也能通过
            String s[] = line.split("\\s+");
            for (int i =0; i < s.length; i++) {
                list.add(s[i]);
            }
            //字典排序类搞定
            Collections.sort(list);
            for(String word :list){
                System.out.print(word+" ");
            }
        }
    }
}
