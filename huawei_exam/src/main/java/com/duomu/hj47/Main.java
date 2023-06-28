package com.duomu.hj47;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 题目描述
 * 信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
 *
 *
 * 1.测量编号不连续的情况，认为是测量结果丢弃。对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
 *
 * 采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
 *
 * 假设第M个测量结果的测量值为A，第N个测量结果的测量值为B。则需要进行(N-M-1)个测量结果的插值处理。进行一阶线性插值估计的第N+i个测量结果(这里题目有问题，应该是M+i)的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
 *
 * 例如：只有测量编号为4的测量结果和测量编号为7的测量结果，测量值分别为4和10
 *
 * 则需要补充测量编号为5和6的测量结果。
 *
 * 其中测量编号为5的测量值=4 + ((10-4)/(7-4))*1 = 6
 *
 * 其中测量编号为6的测量值=4 + ((10-4)/(7-4))*2 = 8
 *
 *
 * 2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
 *
 *
 * 请根据以上规则进行测量结果的整理。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入两个整数m, n
 * 2 输入m个数据组
 *
 * 输出描述:
 * 输出整理后的结果
 *
 * 示例1
 * 输入
 * 2 3
 * 4 5
 * 5 7
 * 输出
 * 4 5
 * 5 7
 */
/*只通过70%是因为当遇到重复项时,我们应该丢弃后出现的(这是题目要求),这时应该用一对变量来保存
第一次出现的重复值,
比如(n没啥用)
4 n
23 5
46 25   (程序中用KEY和VALUE来保存他们)
46 32  (舍弃该对数值)
82 46  (应用82和46进行比较)
对着这个例子把我的程序走一遍就全懂了!就是这么简单,花了我一上午*/
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
        int n=sc.nextInt();
        int m=sc.nextInt();
        //二维数组存储键值对，存储对应的key和value
        int[][] data=new int[n][2];
        for(int i=0;i<n;i++){
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
        }
        ArrayList<String> list=new ArrayList<>();
        //若出现重复值,利用这两个变量存储前一个值,丢弃后出现的重复值(如题目要求)
        int KEY=data[0][0];
        int VALUE=data[0][1];
        list.add(KEY+" "+VALUE);
        for(int i=1;i<n;i++){
            int diff=data[i][0]-KEY;
            if(diff>0){
                //同一插值序列，一步一步往后走
                for(int j=1;j<diff;j++){
                    int key=KEY+j;
                    int value=VALUE+(data[i][1]-VALUE)/(data[i][0]-KEY)*j;
                    list.add(key+" "+value);
                 }
                 list.add(data[i][0]+" "+data[i][1]);
                 KEY=data[i][0];
                 VALUE=data[i][1];
            }else if(diff==0){
                //两个键相等则直接跳过,此时KEY,VVALUE保存的还是上一个值
                continue;
            }else{
                /*注意：实际的测试用例包括多组，可能前几组是一个插值序列，余下几组是另一个插值序列，
                所以else这一步也需要做，前边的key是90到100，后边是1到10，相当于重新开始*/
                list.add(data[i][0]+" "+data[i][1]);
                KEY=data[i][0];
                VALUE=data[i][1];
            }
        }
        for(String s:list)
            System.out.println(s);
        }
    }
}
