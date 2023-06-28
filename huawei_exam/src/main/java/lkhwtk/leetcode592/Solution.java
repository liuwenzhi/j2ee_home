package lkhwtk.leetcode592;

import java.util.ArrayList;
import java.util.List;

/**
 * 592. 分数加减运算
 * 参考题解：官方，核心思路：全部通分，找分母的最小公倍数，多个分母可以先找到前两个的最小公倍数，再用这个最小公倍数
 * 去和下一个分母求最小公倍数，以此类推。最后计算完成之后，分子分母需要做约分，这个时候需要找分子分母的最大公约数。
 */
public class Solution {

    public String fractionAddition(String expression) {
        //定义存放运算符号的列表，注意：计算公式开始的负号：- 不算在这里，下边会单独处理，for循环遍历从1开始
        List<Character> sign = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        }
        //num存放全部分子
        List<Integer> num = new ArrayList<>();
        //den存放全部分母
        List<Integer> den = new ArrayList<>();
        //对计算公式先按照加号：+拆分
        for (String sub: expression.split("\\+")) {
            //按照加号拆分之后，内存循环按照减号：- 拆分，然后拿出每一个待计算的分数的分子和分母，这里注意：如果开头为-1/3这种，
            //按照减号：- 拆出来之后，多拆出来一个空字符串，所以内层for循环在拿具体分数的时候，再增加一个长度是否大于0的判断
            for (String subsub: sub.split("-")) {
                if (subsub.length() > 0) {
                    //过滤到一切运算符号之后，拿到具体分数，按照/拆分出分子和分母
                    String[] fraction = subsub.split("/");
                    num.add(Integer.parseInt(fraction[0]));
                    den.add(Integer.parseInt(fraction[1]));
                }
            }
        }
        //呼应开头，如果表达式首位是一个负数，以负号：-开头，那么分子数组置为相反数
        if (expression.charAt(0) == '-') {
            num.set(0, -num.get(0));
        }
        //初始化多个分母的最小公倍数为1
        int lcm = 1;
        //计算全部分母的最小公倍数，先计算两个的最小公倍数，然后拿着这个最小公倍数和下一个数进行计算，这里的代码非常巧。
        for (int x: den) {
            lcm = lcm_(lcm, x);
        }
        //最小公倍数lcm计算得出结果后，就得到了分数计算的分母，然后需要计算分子，分母经过通分之后，分子需要跟着乘以对应的数值，比如
        //1/2+1/3，得到分母是6，此时1/2需要转成3/6,1/3需要转成2/6，先把分子数组num的第一项计算完，因为sign数组中存放的运算符比操作数要少一个
        int res = lcm / den.get(0) * num.get(0);
        //第一项计算完成之后，再根据具体计算符进行其余的计算
        for (int i = 1; i < num.size(); i++) {
            if(sign.get(i - 1) == '+'){
                res += lcm / den.get(i) * num.get(i);
            }else{
                res -= lcm / den.get(i) * num.get(i);
            }
        }
        //找到分子和分母的最大公约数，注意这里需要用绝对值，不然可能出现1/-6这种情况
        int g = gcd(Math.abs(res), Math.abs(lcm));
        return (res / g) + "/" + (lcm / g);
    }

    /**
     * 求两个正整数最小公倍数的算法，两个整数之积除以两个数的最大公约数
     */
    public int lcm_(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 求两个正整数a和b的最大公约数算法，不论a和b谁大谁小，这个算法都合适
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        //System.out.println(solution.gcd(4,2));
        solution.fractionAddition("-1/2+1/2+1/3");
        //solution.fractionAddition("5/3+1/3");

    }

}
