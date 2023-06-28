package lkhwtk.leetcode3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 核心思路：滑动窗口，保留历史最大长度记录
 * 2021年10月26日，华为一面原题，这么做有问题啊，不能跑完全部用例。
 * 参考Solution的解析
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int maxHistoryLength = 1;
            int right = 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(line.charAt(0));
            while(right<line.length()-1){
                right++;
                if(!stringBuilder.toString().contains(line.charAt(right)+"")){
                    stringBuilder.append(line.charAt(right));
                    if(stringBuilder.toString().length()>maxHistoryLength){
                        maxHistoryLength++;
                    }
                }else{
                    //清空stringBuilder，从right的位置重新开始记录位置，这里错了，应该从重复的第一个位置之后一个位置开始，比如dvdf，第二个d重复了之后，需要从v开始统计
                    stringBuilder.setLength(0);
                    stringBuilder.append(line.charAt(right));
                }
            }
            System.out.println(maxHistoryLength);
        }
    }
}
