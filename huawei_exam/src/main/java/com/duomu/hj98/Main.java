package com.duomu.hj98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 自动售货系统
 * 本题题目冗长，恶心的地方包括以下几点：
 * 1、正常售货机，都是买东西的时候选好商品再投币付钱。本题不是，本题是先投币，然后在售货机里边有一个投币余额，买东西的时候可以从这个余额里边扣；
 * 2、正常售货机，买东西付钱之后会直接找零，本题中的售货机没有，但是可以通过退币的方式把投币余额中的钱拿出来，拿出来的过程中保证用户最小的损失；
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            //多种类型命令按照;拆分
            String[] arr = str.split(";");
            //A1~A6的商品单价，固定值
            int[] price = {2,3,4,5,8,6};
            //钱币面额，1元，2元，5元，10元，固定值
            int[] amount = {1,2,5,10};
            //r命令初始化money 1 2 5 10元张数的数组
            int[] money = new int[4];
            //初始化A1到A6商品数量的数组
            int[] goods = new int[6];
            //投币余额
            int remaining = 0;
            for(String s:arr){
                if(s.startsWith("r ")){
                    //初始化命令，基于题意，不用验证入参，直接初始化
                    System.out.println("S001:Initialization is successful");
                    String[] arr1 = s.split(" ");
                    String[] arr2 = arr1[1].split("-");
                    for(int i = 0;i < arr2.length;i++){
                        goods[i] = Integer.parseInt(arr2[i]);
                    }
                    arr2 = arr1[2].split("-");
                    for(int i = 0;i < arr2.length;i++){
                        money[i] = Integer.parseInt(arr2[i]);
                    }
                }else if(s.startsWith("p ")){
                    //投币命令，注意错误输出需要按照优先级，所以判断的时候也是按照错误的优先级来的
                    int input = Integer.parseInt(s.substring(2));
                    //非1 2 5 10元面额无效
                    if(input!=1 && input!=2 && input!=5 && input!=10){
                        System.out.println("E002:Denomination error");
                        continue;
                    }
                    //如果投入5元10元钱币，但是存钱盒里1元和2元实际额度小于输入，报错
                    if((input==5 || input==10) && (money[0]+money[1]*2<input)){
                        System.out.println("E003:Change is not enough, pay fail");
                        continue;
                    }
                    //在投币的过程中，判断下商品是否是全卖完了，投币和买商品命令不同，投币就判断一次是否全部商品都卖完了
                    boolean flag = true;
                    for(int item:goods){
                        if(item!=0){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.println("E005:All the goods sold out");
                    }else{
                        remaining += input;
                        for(int i = 0;i < amount.length;i++){
                            if(amount[i] == input){
                                money[i]++;
                                break;
                            }
                        }
                        System.out.println("S002:Pay success,balance=" + remaining);
                    }
                }else if(s.startsWith("b ")){
                    //买商品命令，注意错误输出需要按照优先级，所以判断的时候也是按照错误的优先级来的
                    String good = s.substring(2);
                    //不是商品A1~A6报错
                    if(!good.equals("A1") && !good.equals("A2") && !good.equals("A3") && !good.equals("A4") && !good.equals("A5") && !good.equals("A6")){
                        System.out.println("E006:Goods does not exist");
                        continue;
                    }
                    //如果商品卖完了，报错，这里是把商品名称A后边的数字拆出来，然后-1，得到商品数组goods和价格数组price中商品实际下标
                    int name = Integer.parseInt(good.substring(1)) - 1;
                    if(goods[name] == 0){
                        System.out.println("E007:The goods sold out");
                        continue;
                    }
                    //如果投币余额小于商品价格，报错
                    if(remaining < price[name]){
                        System.out.println("E008:Lack of balance");
                    }else{
                        //投币余额满足商品价格，则从余额中扣除商品钱，同时商品数量减一
                        remaining -= price[name];
                        goods[name]--;
                        System.out.println("S003:Buy success,balance=" + remaining);
                    }
                }else if(s.equals("c")){
                    //退币，每一次执行退币，都要把1 2 5 10元四个币种的数量输出一下，每个币种退了多少
                    // 如果余额为0，则无法退币
                    if(remaining == 0){
                        System.out.println("E009:Work failure");
                    }else{
                        StringBuilder sb = new StringBuilder();
                        if(remaining/10 >= money[3]){
                            //投币余额能将存钱盒里边的10元都拿出来的情况
                            remaining -= 10*money[3];
                            sb.append("10 yuan coin number=").append(money[3]);
                            money[3] = 0;
                        }else{
                            //投币余额不能将存钱盒里边的10元都拿出来的情况
                            sb.append("10 yuan coin number=").append(remaining/10);
                            money[3] -= remaining/10;
                            remaining %= 10;
                        }
                        //退5元，2元，1元的方式和10元判断类似
                        if(remaining/5 >= money[2]){
                            remaining -= 5*money[2];
                            //注意：这里都是在开始插入，判断退币的时候顺序是10 5 2 1，返回结果的时候按照1 2 5 10的方式返回
                            sb.insert(0,"\n").insert(0,money[2]).insert(0,"5 yuan coin number=");
                            money[2] = 0;
                        }else{
                            sb.insert(0,"\n").insert(0,remaining/5).insert(0,"5 yuan coin number=");
                            money[2] -= remaining/5;
                            remaining %= 5;
                        }
                        if(remaining/2 >= money[1]){
                            remaining -= 2*money[1];
                            sb.insert(0,"\n").insert(0,money[1]).insert(0,"2 yuan coin number=");
                            money[1] = 0;
                        }else{
                            sb.insert(0,"\n").insert(0,remaining/2).insert(0,"2 yuan coin number=");
                            money[1] -= remaining/2;
                            remaining %= 2;
                        }
                        if(remaining >= money[0]){
                            remaining -= money[0];
                            sb.insert(0,"\n").insert(0,money[0]).insert(0,"1 yuan coin number=");
                            money[0] = 0;
                        }else{
                            sb.insert(0,"\n").insert(0,remaining).insert(0,"1 yuan coin number=");
                            money[0] -= remaining;
                            remaining = 0;
                        }
                        System.out.println(sb);
                        remaining = 0;
                    }
                }else if(s.startsWith("q")){
                    //查询全部商品命令
                    if("q 0".equals(s)){
                        for(int i = 0;i < goods.length;i++){
                            System.out.println("A" + (i+1) + " " + price[i] + " " + goods[i]);
                        }
                    }else if("q 1".equals(s)){
                        //查询存钱盒中钱币信息
                        for(int i = 0;i < money.length;i++){
                            System.out.println(amount[i] + " yuan coin number=" + money[i]);
                        }
                    }else{
                        System.out.println("E010:Parameter error");
                    }
                }
            }
        }
    }

}
