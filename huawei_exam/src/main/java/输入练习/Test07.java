package 输入练习;

import java.util.Scanner;

public class Test07 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int result = 0;
            String[] s = str.split(" ");
            for(int i=0;i<s.length;i++){
                result += Integer.parseInt(s[i]);
            }
            System.out.println(result);
        }
    }
}
