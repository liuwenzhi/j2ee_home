package 输入练习;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 注意：nextInt和nextLine一起用可能会有问题
 * nextInt读取完一个整形数字之后，nextLine换行读可能有问题
 */
public class Test08 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String str[] = line.split(" ");
        Arrays.sort(str);
        for(int i=0;i<num;i++){
            System.out.print(str[i]+" ");
        }
        scanner.close();
    }
}
