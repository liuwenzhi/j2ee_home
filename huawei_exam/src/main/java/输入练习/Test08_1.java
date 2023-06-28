package 输入练习;

import java.util.*;

/**
 * 基于Collections的字典排序实现，这个代码复杂一点，需要将输入封装到list列表中，但是效率差不多
 */
public class Test08_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String str[] = line.split(" ");
        List<String> list = new ArrayList<>(num);
        for(int i=0;i<num;i++){
            list.add(str[i]);
        }
        Collections.sort(list);
        for(String s:list){
            System.out.print(s+" ");
        }
        scanner.close();
    }

}
