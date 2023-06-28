package com.duomu.hj34;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] c = new char[line.length()];
            for(int i=0;i<c.length;i++){
                c[i] = line.charAt(i);
            }
            Arrays.sort(c);
            for(char c1:c){
                System.out.print(c1);
            }
            //注意：这个换行非常重要，没有就不通过
            System.out.println();
        }
    }
}
