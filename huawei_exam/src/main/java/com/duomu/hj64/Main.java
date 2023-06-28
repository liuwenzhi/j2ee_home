package com.duomu.hj64;

/**
 * 具体题干详细见截图
 * 输入描述:
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 本题含有多组输入数据！
 *
 *
 * 输出描述:
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 * 示例1
 * 输入
 * 复制
 * 10
 * UUUU
 * 输出
 * 复制
 * 7 8 9 10
 * 7
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            String str = sc.next();
            int top =1, index =1;
            for(int i=0;i<str.length();i++) {
                if(str.charAt(i) =='U') {
                    if(top == index) { top = top ==1 ? num -3 : top -1;
                    }
                    index = (index ==1) ? num : index -1;
                }else if(str.charAt(i) =='D') {
                    if(top +3 == index) {
                        top = index == num ?1 : top +1;
                    }
                    index = index == num ?1 : index +1;
                }
            }
            if(num <4) top =1;
            for(int i=0; i<3 && i<num-1; i++) {
                System.out.print(top + i +" ");
            }
            System.out.println(top+(4>num?num-1:3));
            System.out.println(index);
        }
    }
}
