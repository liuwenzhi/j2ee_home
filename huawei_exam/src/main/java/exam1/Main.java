package exam1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目大体意思：第一行是多个货物重量，第二行货车总共载重量，求出最多能载几件货物
 * 输入
 * 5,10,2,11
 * 20
 * 输出
 * 3
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //快递货物重量
            String weightLine = scanner.nextLine();
            String[] weightInfo = weightLine.split(",");
            int[] weights = Arrays.stream(weightInfo).mapToInt(Integer::parseInt).toArray();
            int carLoad = scanner.nextInt();
            int maxLoad = loadInfo(weights,carLoad);
            System.out.println(maxLoad);
        }
    }

    /**
     * 货物从小到大排序，然后从小的往大的加，看看是否超载
     */
    private static int loadInfo(int[] weights,int carLoad){
        Arrays.sort(weights);
        //临时变量记录货物总重量
        int temp = 0;
        //装载货物数量
        int result = 0;
        for(int i:weights){
            if(temp+i<=carLoad){
                temp = temp+i;
                result ++;
            }
        }
        return result;
    }
}
