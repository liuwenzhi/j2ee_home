package com.duomu.hj27;
import java.util.*;
import java.io.*;

/**
 * Main1和Main的思路一致，只是改变了流获取入参的方式
 */
public class Main1 {
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while((str = bf.readLine()) != null){
            String[] items = str.split(" ");
            int N = Integer.parseInt(items[0]);
            String word = items[items.length - 2];
            int index = Integer.parseInt(items[items.length - 1]);
            List<String> dictlist = new LinkedList<>();
            for(int i = 1; i <= N; i++){
                if(word.length() == items[i].length() && !word.equals(items[i])){
                    if(isBrother(word, items[i])){
                        dictlist.add(items[i]);
                    }
                }
            }
            Collections.sort(dictlist);
            System.out.println(dictlist.size());
            if(1 <= index && index <= dictlist.size()){
                System.out.println(dictlist.get(index - 1));
            }
        }
        bf.close();

    }

    private static boolean isBrother(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
