package moni;

import java.util.Scanner;

/**
 * 找车位问题
 * 距离最近的停车位距离是最大的
 * 输入：1,0,0,0,0,1,0,0,1,0,1
 * 输出：2
 */
public class Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] temp = scanner.nextLine().split(",");
            //根据题目要求，至少有一个车位，则距离最近的停车位最大距离至少是1
            int max = 1;
            for(int i=0;i<temp.length;i++){
                if("1".equals(temp[i])){
                    //如果停车位被占用则直接下一次循环
                    continue;
                }else{
                    int index1 = i-1;
                    boolean flag1 = false;
                    int index2 = i+1;
                    boolean flag2 = false;
                    while(index1>=0){
                        if("1".equals(temp[index1])){
                            //左侧找到车
                            flag1 = true;
                            break;
                        }
                        index1--;
                    }
                    while(index2<temp.length){
                        if("1".equals(temp[index2])){
                            //右侧找到车
                            flag2 = true;
                            break;
                        }
                        index2++;
                    }
                    if(flag1&&flag2){
                        //左右侧都找到车，进行比对
                        int cache = (i-index1)>(index2-i)?(index2-i):(i-index1);
                        max = max>cache?max:cache;
                    }else if(flag1&&!flag2){
                        //只有左侧有车的情况
                        max = i - index1;
                    }else if(!flag1&&flag2){
                        //只有右侧有车的情况
                        max = index2 - i;
                    }else{
                        //左右侧都没有车，循环走了到了唯一的车位上，直接下一次循环，这种情况已经在循环中第一步排除了
                        continue;
                    }
                }
            }
            System.out.println(max);
        }
        scanner.close();
    }
}
