package 输入练习;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int i=0;
        while(i<num){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
            i++;
        }
    }
}
