package moni;

import java.util.Scanner;

/**
 * 有效字符串，题目信息回去自己截屏下
 */
public class Test1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            char[] temp = scanner.nextLine().toCharArray();
            String line = scanner.nextLine();
            int result = -1;
            //中间记录变量，标记短字符串中的字符按顺序在常字符串中存在的个数
            int cache = 0;
            for(int i=0,j=0;i<temp.length&&j<line.length();j++){
                if(line.charAt(j)==temp[i]){
                    i++;
                    cache++;
                    result = j;
                }
            }
            //循环结束之后，如果cache的值等于temp的长度，那么就返回result的值，否则返回-1
            if(cache == temp.length){
                System.out.println(result);
            }else{
                System.out.println(-1);
            }
        }
        scanner.close();
    }
}
