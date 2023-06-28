package 输入练习;

import java.util.Arrays;
import java.util.Scanner;

public class Test09 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] str = line.split(" ");
            Arrays.sort(str);
            for(int i=0;i<str.length;i++){
                //不用这么搞，直接按照Test08那样的输出即可，每行最后多一个空格看不出来什么
                /*System.out.print(str[i]);
                if(i!=str.length-1){
                    System.out.print(" ");
                }*/
                System.out.print(str[i]+" ");
            }
            System.out.println();
        }
    }
}
