package 输入练习;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
