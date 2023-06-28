package lkhwtk.leetcode640;

import java.util.ArrayList;
import java.util.List;

/**
 * 640. 求解方程
 * 参考题解：官方
 */
public class Solution {
    /**
     * 解析x前边的系数，注意这个地方非常细，拿过来的入参，可能是：
     * x,-3x,+x,3x这几种情况
     */
    public String coeff(String x) {
        //如果x前边带有系数，那么就把x替换为空字符串
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        //如果x前边不带有系数，可能什么也没有，可能有正负号，那么直接把x替换为1
        return x.replace("x", "1");
    }

    public String solveEquation(String equation) {
        //将方程左右两边拆开，得到一个左右数组
        String[] lr = equation.split("=");
        //lhs用于保存x前边的系数计算结果，rhs用于保存数字前边系数的计算结果
        int lhs = 0, rhs = 0;
        //使用breakIt方法解析方程等号左边多项式
        for (String x: breakIt(lr[0])) {
            //如果该项包含x
            if (x.indexOf("x") >= 0) {
                //解析x前边的系数，并累加（按照方程的计算规则，x都移动到等号左边，左侧的x直接累加）
                lhs += Integer.parseInt(coeff(x));
            } else {
                //如果该项是数字，rhs做差（按照方程的计算规则，数值都移动到等号右边，左侧的数字需要做减法）
                rhs -= Integer.parseInt(x);
            }
        }
        //使用breakIt方法解析方程等号右边多项式，解析内容和上边解析左侧多项式类似，需要注意的是x系数做差，数字做和，这次是右边
        for (String x: breakIt(lr[1])) {
            if (x.indexOf("x") >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            }else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0) {
                //如果最终的左右系数都为0，则为无穷多解，此时相当于方程转为0*x=0这种形式
                return "Infinite solutions";
            } else {
                //如果只有x系数为0，而数字不为0，类似这种情况：0*x = 1，此时无解
                return "No solution";
            }
        }
        //如果方程有唯一解，按照题意，返回一个整形解
        return "x=" + rhs / lhs;
    }

    /**
     * 解析方程等号左右边的表达式,注意：方程只包含+和-操作
     * 该方法的作用是：将一个多项式，比如：x+5-3+x，拆成
     * x，+5，-3，x，拆分出来的是带有符号的单项式，其中x
     * 可能是包括系数的，比如多项式为3x+2,按照本方法拆分
     * 之后得到的就是3x，+2
     */
    public List<String> breakIt(String s) {
        List<String> res = new ArrayList<>();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                //在扫描多项式的过程中，如果出现了扫描到计算符号，同时缓存表达式r长度大于0，则把当前计算符号的前一个单项式放到list结果列表中
                if (r.length() > 0) {
                    res.add(r);
                }
                //重新复制临时单项式表达式，r赋值为当前计算符号
                r = "" + s.charAt(i);
            } else {
                //如果没有扫描到符号，就把数字或者x拼接到r的后边，如果是首次扫描的x或者数字，不带有符号，在之后的扫描过程中，都会带有符号
                r += s.charAt(i);
            }
        }
        res.add(r);
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        //System.out.println(solution.solveEquation("x+5-3+x=6+2x-2"));
        //System.out.println("-x".charAt("-x".length() - 2));
        //字符串代表一个负数，可以直接通过Integer的接口方法转成整形
        System.out.println(Integer.parseInt("-1"));
        System.out.println(Integer.valueOf("-1"));
    }
}
