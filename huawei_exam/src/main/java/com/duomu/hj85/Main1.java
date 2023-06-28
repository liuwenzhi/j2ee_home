package com.duomu.hj85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            System.out.println(palindrome(line));
        }
    }
    private static int palindrome(String str) {
        int len = str.length();
        int max = 1;
        for(int i = 1; i < len; i++){
            //回文数是偶数情况，每次循环都是相邻两个
            int low = i-1;
            int high = i;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }
            /*注意：这里为啥是high-low-1，因为此刻上边while循环结束之后，low比实际回文数最小下标小1，high大1，
            实际回文数下标位置是 low+1到high-1，然后从low+1到high-1这两个下标之间，一共有数字（high-1）—（low+1）+1，这个值是high-low-1
            */
            if(high-low-1 > max){
                max = high-low-1;
            }

            //回文数是奇数情况，每次循环都是遍历隔一个的两个元素
            low = i-1;
            high = i+1;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)){
                low--;
                high++;
            }
            if(high-low-1 > max){
                max = high-low-1;
            }
        }
        return max;
    }
}
