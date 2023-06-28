package com.duomu.hj86;

import java.util.Scanner;

/**
 * 86题很巧妙的一种解法，split按照多个0来拆分
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            String binaryString = Integer.toBinaryString(number);
            //再将字符串按多个0分割
            String[] strings = binaryString.split("0+");
            int count = 0;
            for (String string : strings) {
                count = Math.max(count, string.length());
            }
            System.out.println(count);
        }
    }
}
