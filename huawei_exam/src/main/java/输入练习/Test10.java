package 输入练习;

import java.util.Arrays;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] str = line.split(",");
            Arrays.sort(str);
            for(int i=0;i<str.length;i++){
                System.out.print(str[i]);
                if(i!=str.length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
