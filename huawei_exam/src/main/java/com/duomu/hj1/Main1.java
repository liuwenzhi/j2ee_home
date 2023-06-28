package com.duomu.hj1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String temp[] = line.split(" ");
            int length = temp.length;
            System.out.println(temp[length-1].length());
        }
        scanner.close();
    }
}
