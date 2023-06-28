package com.duomu.hj6;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.next());
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sb.append(i).append(" ");
                    num = num / i;
                    //注意：每一次num能被i整除，num = num/i，i要回退一次
                    i--;
                }
            }
            //最后需要单独补上一个余数
            sb.append(num).append(" ");
            System.out.println(sb.toString());
        }
    }

}
