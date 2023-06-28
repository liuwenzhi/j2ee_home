package com.player2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            String[] temp = line.split(",");
            //通过String类内置的比较方法进行比对，如果是拼接最大数就是：Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
            Arrays.sort(temp, (x, y) -> (y + x).compareTo(x + y));

            StringBuilder res = new StringBuilder();
            for(int i=0;i<temp.length;i++) {
                res.append(temp[i]);
            }
            String result = res.toString();
            //单独处理下以0开头的情况，00,000,0000，因为本题是求解最大数，所以只可能有这几种情况
            if(result.startsWith("0")){
                System.out.println("0");
            }
            System.out.println(result);
        }
    }
}
