package zjtest;

import java.util.Scanner;

/**
 * 之江实验室上机考试题1（2021/05/16）
 * 题目描述：
 * 我们称仅由01构成且不含前导0的数字称为01数（注意，我们认为数字0是最小的01数）现在我们将这些数字从小到大排列。给出一个数字k，请你找出第k个01数是多少。
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num==1){
            System.out.println(0);
            return;
        }else{
            num = num-1;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=31;i>=0;i--){
            sb.append((num>>>i)&1);
        }
        String temp = sb.toString();
        int length = temp.length();
        for(int i=0;i<length;i++){
            if(temp.charAt(i)=='1'){
                System.out.println(temp.substring(i,length));
                break;
            }
        }
    }
}
