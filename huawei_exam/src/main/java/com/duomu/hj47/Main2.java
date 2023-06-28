package com.duomu.hj47;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] niubi = new int[m][2];
            for (int i = 0; i < m; i++) {
                niubi[i][0] = scanner.nextInt();
                niubi[i][1] = scanner.nextInt();
            }
            int last = niubi[0][0];
            int last_value = niubi[0][1];
            System.out.println(last + " " + last_value);
            for (int i = 1; i < m; i++) {
                int now = niubi[i][0];
                int now_value = niubi[i][1];
                if (now - last != 0) {
                    for (int j = last + 1; j < now; j++) {
                        System.out.println(j + " " + (last_value + (now_value - last_value) / (now - last) * (j - last)));
                    }
                    System.out.println(now + " " + now_value);
                    last = now;
                    last_value = now_value;
                }
            }
        }
    }
}
