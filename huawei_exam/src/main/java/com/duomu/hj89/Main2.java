package com.duomu.hj89;

import java.util.Scanner;
import java.util.Stack;

/**
 * 67题也是24点计算，和本题略有不同
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out: // 定义外部循环别名
        while (scanner.hasNextLine()) {
            // 初始化数字数组和标志数组以及栈
            String[] split = scanner.nextLine().split(" ");
            int[] nums = new int[4];
            int[] signs = new int[4];
            Stack<Object> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                int num = str2Num(split[i]); // 字符转数字
                // 如果有鬼牌，输出ERROR，结束处理
                if (num == -1) {
                    System.out.println("ERROR");
                    continue out;
                }
                nums[i] = num;
            }

            for (int i = 0; i < nums.length; i++) {
                signs[i] = 1;
                stack.push(nums[i]);
                if (dfs(nums, signs, nums[i], 24, stack)) {
                    break;
                }
                signs[i] = 0;
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.println("NONE");// 如果无法得到24，输出NONE
            } else {
                for (Object o : stack) {
                    if (o instanceof Integer) {
                        o = num2Str((int) o);// 数字转字符
                    }
                    System.out.print(o);
                }
                System.out.println();
            }
        }
    }

    private static boolean dfs(int nums[], int[] signs, int v, int required, Stack<Object> stack) {
        boolean allVisited = true;// 四个角均被访问
        for (int sign : signs) {
            if (sign == 0) {
                allVisited = false;
            }
        }

        if (allVisited) {
            return v == required; // 在所有节点均被访问的前提下，判断最后的结果是否为所需要的结果。
        }

        // 访问所有的邻接顶点
        for (int i = 0; i < nums.length; i++) {
            if (signs[i] == 0) {
                signs[i] = 1;

                // 加法
                stack.push("+");
                stack.push(nums[i]);
                if (dfs(nums, signs, v + nums[i], required, stack)) {
                    return true;
                }
                stack.pop();
                stack.pop();

                // 减法
                stack.push("-");
                stack.push(nums[i]);
                if (dfs(nums, signs, v - nums[i], required, stack)) {
                    return true;
                }
                stack.pop();
                stack.pop();

                // 乘法
                stack.push("*");
                stack.push(nums[i]);
                if (dfs(nums, signs, v * nums[i], required, stack)) {
                    return true;
                }
                stack.pop();
                stack.pop();

                // 除法
                stack.push("/");
                stack.push(nums[i]);
                if (nums[i] != 0 && v % nums[i] == 0 && dfs(nums, signs, v / nums[i], required, stack)) {
                    return true;
                }
                stack.pop();
                stack.pop();

                signs[i] = 0; // 回溯
            }
        }

        return false;//当所有情况均得不到需要的结果，返回false。
    }

    private static int str2Num(String letter) {
        int num;
        switch (letter) {
            case "joker":
            case "JOKER":
                num = -1;
                break;
            case "A":
                num = 1;
                break;
            case "J":
                num = 11;
                break;
            case "Q":
                num = 12;
                break;
            case "K":
                num = 13;
                break;
            default:
                num = Integer.parseInt(letter);
                break;
        }
        return num;
    }

    private static String num2Str(int num) {
        String str;
        switch (num) {
            case 1:
                str = "A";
                break;
            case 11:
                str = "J";
                break;
            case 12:
                str = "Q";
                break;
            case 13:
                str = "K";
                break;
            default:
                str = Integer.toString(num);
                break;
        }
        return str;
    }

}
