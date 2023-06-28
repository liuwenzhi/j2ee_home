package 输入练习;

import java.util.Scanner;

public class Test06 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int result = 0;
            for(int i=0;i<n;i++){
                result += scanner.nextInt();
            }
            /*int i = 0;
            while(i<n){
                result += scanner.nextInt();
                i++;
            }*/
            System.out.println(result);
        }
    }
}
