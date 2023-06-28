package com.duomu.hj58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            int n = Integer.parseInt(line.split("\\s+")[0]);
            int k = Integer.parseInt(line.split("\\s+")[1]);
            String line2 = br.readLine();
            String temp[] = line2.split("\\s+");
            int cache[] = new int[temp.length];
            for(int i=0;i<temp.length;i++){
                cache[i]=Integer.parseInt(temp[i]);
            }
            Arrays.sort(cache);
            for(int i=0;i<k;i++){
                System.out.print(cache[i]+" ");
            }
            //备注：这个换行非常重要，没有就不通过
            System.out.println();
        }
    }
}
