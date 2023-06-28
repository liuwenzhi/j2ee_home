package com.duomu.hj94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 题目描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 * 输入描述:
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 输出
 * 复制
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            //候选人数
            int candidateNum = Integer.parseInt(line);
            List<String> candidateList = new ArrayList<>(candidateNum);
            //map里边存放候选人票数信息，外加一个不合法票数
            Map<String,Integer> map = new HashMap<>(candidateNum+1);
            String[] candidateInfo = br.readLine().split(" ");
            for(int i=0;i<candidateNum;i++){
                candidateList.add(candidateInfo[i]);
                map.put(candidateInfo[i],0);
            }
            map.put("Invalid",0);
            //投票人数
            int voter = Integer.parseInt(br.readLine());
            String[] votes = br.readLine().split(" ");
            for(String vote:votes){
                if(map.containsKey(vote)){
                    int value = map.get(vote);
                    map.put(vote,++value);
                }else{
                    int value = map.get("Invalid");
                    map.put("Invalid",++value);
                }
            }
            for(String key:candidateList){
                System.out.println(key+" : "+map.get(key));
            }
            System.out.println("Invalid : "+map.get("Invalid"));
        }
    }
}
