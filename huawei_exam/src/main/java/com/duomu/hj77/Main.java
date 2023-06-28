package com.duomu.hj77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
/**
 * 题目描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，
 * 同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。要求以字典序排序输出火车出站的序列号。
 *
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 * 示例1
 * 输入
 * 3
 * 1 2 3
 * 输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 */
public class Main {

    /**list常量列表存储结果字符串集合*/
    private static ArrayList<String> LIST = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            LIST.clear();
            //输入火车数量
            int num=in.nextInt();
            int[] trains = new int[num];
            Stack<Integer> stack=new Stack<>();
            for(int i=0;i<num;i++) {
                trains[i]=in.nextInt();
            }
            trainOut(trains,0,stack,"",0);
            //通过字典排序对结果集合排序
            Collections.sort(LIST);
            for(String str:LIST) {
                System.out.println(str);
            }
        }
        in.close();
    }

    /**
     * 根据火车入站出站信息递归实现出站列表
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
            stack.push(trains[pullInTimes]);
            //入栈后递归执行1次入栈，2次入栈，多次入栈的情况
            trainOut(trains,pullInTimes+1,stack,str,outTimes);
            //回溯（即恢复现场，当前if方法中第一步入栈一个火车，这里再出站这个火车），走下一次递归链路
            stack.pop();
        }
    }
}
