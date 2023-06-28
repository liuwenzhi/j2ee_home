package 输入练习;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //组数
            int num = scanner.nextInt();
            for(int i=0;i<num;i++){
                //每行元素个数
                int col = scanner.nextInt();
                int result = 0;
                for(int j=0;j<col;j++){
                    result += scanner.nextInt();
                }
                System.out.println(result);
            }
        }
    }
}
