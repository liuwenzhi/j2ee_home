package com.duomu.hj70;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 *     A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * 编写程序计算不同的计算顺序需要进行的乘法次数
 * 输入描述:
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 输出描述:
 * 输出需要进行的乘法次数
 * 示例1
 * 输入
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 * 输出
 * 3500
 */
class MatrixObject{
    /**矩阵行元素个数*/
    int x;
    /**矩阵列元素个数*/
    int y;
    public MatrixObject(int x,int y){
        this.x = x;
        this.y = y;
    }
    /**计算次数*/
    int countTimes;
    public MatrixObject(int x,int y,int countTimes){
        this.x = x;
        this.y = y;
        this.countTimes = countTimes;
    }
}
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //矩阵数
            int n = scanner.nextInt();
            List<MatrixObject> matrixList = new ArrayList<>(n);
            for(int i=0;i<n;i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                MatrixObject matrixObject = new MatrixObject(x,y);
                matrixList.add(matrixObject);
            }
            String strExpression = scanner.next();
            System.out.println(getCountTimes(matrixList,strExpression));

        }
        scanner.close();
    }

    /**
     * 统计矩阵计算次数
     */
    private static int getCountTimes(List<MatrixObject> matrixList,String strExpression){
        Stack<MatrixObject> stack = new Stack<>();
        //最终返回计算次数结果
        int countResult = 0;
        //控制遍历列表的变量
        int m = matrixList.size()-1;
        //注意：这里的表达式进栈方式采用从后往前
        for(int i=strExpression.length()-1;i>=0;i--){
            if(Character.isLetter(strExpression.charAt(i))){
                //如果是字母，则matrixList列表对应的编号进栈，从后往前进栈，保证出栈的时候后进去的先出来，能进行正常计算
                stack.push(matrixList.get(m));
                m--;
            }else if(strExpression.charAt(i)=='('){
                //如果是左括号，则弹出两个元素进行计算，弹出前边的左括号，然后把计算结果压入栈，注意先出来的是一次计算中后边的矩阵
                MatrixObject matrixObject1 = stack.pop();
                MatrixObject matrixObject2 = stack.pop();
                MatrixObject matrixObject = matrixComputeTimes(matrixObject1,matrixObject2);
                countResult += matrixObject.countTimes;
                //将这次计算结果压入栈
                stack.push(matrixObject);
            }else{
                //右括号不管
            }
        }
        return countResult;
    }

    /**
     * 两个矩阵相乘，需要计算的次数,以及矩阵计算后的结果
     */
    private static MatrixObject matrixComputeTimes(MatrixObject matrixObject1,MatrixObject matrixObject2){
        int x = matrixObject1.x;
        int y = matrixObject1.y;
        int z = matrixObject2.y;
        //两个矩阵计算的乘法次数，可以用第一个矩阵的行数* 第一个矩阵的列数或第二个矩阵的行数（这俩一定得相等才能计算）*第二个矩阵的列数
        int result= x*y*z;
        MatrixObject matrixObject = new MatrixObject(x,z,result);
        return matrixObject;
    }
}

