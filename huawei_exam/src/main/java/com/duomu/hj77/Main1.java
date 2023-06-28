package com.duomu.hj77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main1 {
    /**list常量列表存储结果字符串集合*/
    private static ArrayList<String> LIST = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while((line=br.readLine())!=null){
            LIST.clear();
            //输入火车数量
            int num = Integer.parseInt(line);
            int[] trains = new int[num];
            Stack<Integer> stack=new Stack<>();
            String[] temp = br.readLine().split(" ");
            for(int i=0;i<num;i++) {
                trains[i]=Integer.parseInt(temp[i]);
            }
            trainOut(trains,0,stack,"",0);
            //通过字典排序对结果集合排序
            Collections.sort(LIST);
            for(String str:LIST) {
                System.out.println(str);
            }
        }
    }

    /**
     * 根据火车入站出站信息递归实现出站列表，核心思路是两次递归回溯的组合，实际想法是：以a b c 为例
     * （开始stack为空，走入栈的if判断，a进站）入栈trainOut递归->（栈非空，a出站）出栈trainOut递归->（栈空了，走入栈if，b进站）入栈trainOut递归->（栈非空，走出站if,b出站）出栈trainOut
     * （c进站）入栈trainOut->（c出站）出站trainOut，再一步一步回溯，两个递归回溯方向相互配合调用，入参非常严密
     *
     * @param trains 火车编号集合 1 2 3
     * @param pullInTimes 进站次数
     * @param stack 辅助栈对象
     * @param outTimes 出站次数
     */
    public static void trainOut(int[] trains,int pullInTimes,Stack<Integer> stack,String str,int outTimes) {
        //如果所有火车均出栈则将当前结果保存，一次递归链路执行完成，接下来通过回溯走下一个链路
        if(outTimes==trains.length) {
            LIST.add(str);
        }
        //栈非空时出栈
        if(!stack.empty()) {
            int temp=stack.pop();
            //出栈后归队执行1次出栈，2次出栈，多次出栈的情况
            trainOut(trains,pullInTimes,stack,str+temp+" ",outTimes+1);
            //回溯（即恢复现场，当前if方法中第一步弹出temp，这里再把temp放回去），走下一次递归链路
            stack.push(temp);
        }
        //若有火车没有都入栈则入栈
        if(pullInTimes<trains.length) {
            //入栈的车号和pullInTimes对上
            stack.push(trains[pullInTimes]);
            //入栈后递归执行1次入栈，2次入栈，多次入栈的情况
            trainOut(trains,pullInTimes+1,stack,str,outTimes);
            //回溯（即恢复现场，当前if方法中第一步入栈一个火车，这里再出站这个火车），走下一次递归链路
            stack.pop();
        }
    }
}
