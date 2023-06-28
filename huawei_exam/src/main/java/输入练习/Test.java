package 输入练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String str[] = line.split(" ");
        List<Integer> list = new ArrayList<>(num);
        for(int i=0;i<num;i++){
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        for(int i:list){
            System.out.print(i+" ");
        }
        scanner.close();
    }
}
