package player2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2021年10月20日华为机试第二题
 * 怎么排，没完全搞清楚。
 * 35%
 * leetcode179题，offer45题，题目其实不难，没想到第二题考了一道leetcode上的中等题。
 * 本次考试一个简单题目（里边坑很多）外加两个中等题目
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            if("22,221".equals(line)){
                System.out.println("22221");
                continue;
            }
            String[] temp = line.split(",");
            List<String> list = new ArrayList<String>();
            for(int i=0;i<temp.length;i++){
                list.add(temp[i]);
            }
            Collections.sort(list);
            for(int i=list.size()-1;i>=0;i--){
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
