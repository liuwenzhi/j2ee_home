package com.duomu.hj47;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 47题本身题干说明有问题，输入N没啥用。
 * 输入的m代表输入m个一维数组，每个数组中两个元素，分别对应key和value
 * 然后连续则不用管，重复就去掉，不连续就插值。
 * 进行一阶线性插值估计的第N+i个测量结果的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
 * 题干说明中这句话有问题，不是第N+i，是第M+i
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            int total = Integer.parseInt(line.split("\\s+")[0]);
            if (total > 0) {
                StringBuilder sb = new StringBuilder();
                String thisLine = br.readLine();
                String[] elements = thisLine.split("\\s+");
                int num = Integer.parseInt(elements[0]);
                int value = Integer.parseInt(elements[1]);
                int preNum = num;
                int preValue = value;
                sb.append(thisLine + "\r\n");
                for (int i = 1; i < total; i++) {
                    thisLine = br.readLine();
                    elements = thisLine.split("\\s+");
                    num = Integer.parseInt(elements[0]);
                    value = Integer.parseInt(elements[1]);
                    if (num == preNum) {
                        continue;
                    }
                    for (int j = preNum + 1; j < num; j++) {
                        sb.append(j + " " + (preValue + (value - preValue) / (num - preNum) * (j - preNum)) + "\r\n");
                    }
                    preNum = num;
                    preValue = value;
                    sb.append(thisLine + "\r\n");
                }
                System.out.print(sb.toString());
            }

        }

    }
}
