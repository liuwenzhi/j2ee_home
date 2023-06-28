package 输入练习;

import java.util.Scanner;
/**
 * 备注：本题中，内部嵌套的循环使用while和for都可以
 * 之前一个试题使用while出现过问题
 */
public class Test04 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int result = 0;
            if(n==0){
                break;
            }
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
