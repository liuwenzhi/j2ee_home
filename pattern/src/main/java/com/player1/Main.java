package com.player1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 2021年10月20日华为机试第一题：
 * 本题最大坑点在于题目说了，测试用例保证至多只有一组满足条件的测试用例，所以必须要做去重相关处理。
 * 100%
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null){
            //数组元素个数
            int N = Integer.parseInt(line);
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(num);
            boolean flag = false;
            for(int i=N-1;i>=2;i--){
                for(int j=i-1;j>=1;j--){
                    //这个for循环中的break语句价值25分，保证了没有重复输出，最后25分靠这两个点。
                    for(int k=j-1;k>=0;k--){
                        if(num[i]==num[j]+2*num[k]){
                            flag = true;
                            System.out.println(num[i]+" "+num[j]+" "+num[k]);
                            break;
                        }else if(num[i]==2*num[j]+num[k]){
                            flag = true;
                            System.out.println(num[i]+" "+num[k]+" "+num[j]);
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                System.out.println(0);
            }
        }
    }
}
