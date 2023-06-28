package com.duomu.hj93;
import java.util.*;
/**
 * 题目描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，输出true；不满足时输出false。
 * 本题含有多组样例输入。
 * 输入描述:
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述:
 * 返回true或者false
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 输出
 * 复制
 * true
 * 说明
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 */
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5 = 0;
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();
                if (cur % 5 == 0){
                    sum5 += cur;
                }else if (cur % 3 == 0){
                    sum3 += cur;
                }else{
                    list.add(cur);
                }
                sum += cur;
            }
            //核心递归思路中，target的设计是堵一边，把sum3或者sum5排除掉，这里减去sum5也可以，然后看能否从list中找到元素使target能减到0
            //target已经是sum/2减去了sum3了，如果能够从list中找出几个元素，使target能减去这几个元素之后变成0，那么原数组就能拆分出两个数组，其中3的倍数在一个数组中，5的倍数在一个数组中
            int target = sum/2 - sum3;
            if (sum % 2 != 0){
                System.out.println("false");
            }else{
                System.out.println(helper(0,list, target));
            }
        }
    }

    /**
     * 递归的核心思路是是，要么在target中去掉当前元素值，要么不去掉，这样做一个二叉树一样一层一层往下走
     * 看看最终能否让target减到0
     */
    private static boolean helper(int l, LinkedList<Integer> list, int target){
        if (l == list.size()){
            return target == 0;
        }
        //递归遍历target减去当前元素或者不减去当前元素两种情况，递归的出口是第一个元素l的长度是否达到了list.size()
        return helper(l + 1, list, target - list.get(l)) || helper(l + 1, list, target);
    }
}
