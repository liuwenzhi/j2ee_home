package com.duomu.hj66;

import java.util.Scanner;

/**
 * 投机取巧的一种做法，不太可取
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = "reset";
        String s2 = "reset board";
        String s3 = "board add";
        String s4 = "board delete";
        String s5 = "reboot backplane";
        String s6 = "backplane abort";

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.matches(s1)){
                System.out.println("reset what");
            }else if (s.matches(s2)) {
                System.out.println("board fault");
            }else if (s.matches(s3)) {
                System.out.println("where to add");
            }else if (s.matches(s4)) {
                System.out.println("no board at all");
            }else if (s.matches(s5)) {
                System.out.println("impossible");
            }else if (s.matches(s6)) {
                System.out.println("install first");
            }else{
                System.out.println("unknown command");
            }
        }
    }
}
