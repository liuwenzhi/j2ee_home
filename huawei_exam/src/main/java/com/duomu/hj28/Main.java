package com.duomu.hj28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）
 * 个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组
 * 将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入:
 *
 * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
 *
 * 输出:
 *
 * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 *
 * 输入描述:
 * 输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 注意：数据可能有多组
 *
 * 输出描述:
 * 求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 2 5 6 13
 * 2
 * 3 6
 * 输出
 * 复制
 * 2
 * 0
 */
public class Main {
    /**
     * 首先一个前提：如果两个数字都是偶数，则和为偶数，肯定不是素数。两个数字都为奇数，和为偶数，肯定不是素数，有一个特例
     * 1和1，但是题干中给出：自然数的取值范围是[2,30000]，所以肯定不会出现1,1这种情况。所以组合只会出现在奇数和偶数之间。
     * 核心思路：
     * 如果第j个偶数没有伴侣，奇数x和它的和能组成素数，则设置为他们为伴侣；否则，第j个偶数原来有伴侣的话，如果他的原伴侣能够重新找到伴侣，
     * 则奇数x设置为第j个偶数的伴侣（递归。。）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int N = Integer.parseInt(str);
            long[] nums = new long[N];
            String[] str1 = sc.nextLine().split(" ");
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(str1[i]);
            }
            //这种方式转数组看着高大上，实际效率低很多。
            //Arrays.stream(str1).mapToLong(Long::parseLong).toArray();
            // 偶数部分
            ArrayList<Long> evens = new ArrayList<Long>();
            // 奇数部分
            ArrayList<Long> odds = new ArrayList<Long>();
            for (int i = 0; i < N; i++) {
                if (nums[i] % 2 == 0) { // 偶数
                    evens.add(nums[i]);
                } else { // 奇数
                    odds.add(nums[i]);
                }
            }
            //偶数匹配数组
            long[] evensMatch = new long[evens.size()];
            int result = 0;
            for (int i = 0; i < odds.size(); i++) {
                //遍历每一个奇数的时候，都重新初始化一遍偶数使用情况used数组
                int[] used = new int[evens.size()];
                if (find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);

        }
        sc.close();
    }

    /**
     * 判断是否是素数
     */
    private static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param x 待匹配的奇数
     * @param evens 偶数列表
     * @param used 偶数使用情况数组，用了就是1，没用就是0
     * @param evensMatch 偶数匹配数组
     */
    public static boolean find(long x, ArrayList<Long> evens, int[] used, long[] evensMatch) {
        for (int j = 0; j < evens.size(); j++) {
            //如果偶数列表中当前元素和奇数x的累加和是一个素数，并且当前偶数还没有被使用，则在used数组中先标记当前偶数已经使用
            if (isPrime(x + evens.get(j)) && used[j] == 0) {
                used[j] = 1;
                //如果当前偶数匹配数组还没有元素，则设置该偶数和这个奇数x匹配。
                //或者是当前有匹配的奇数，但是这个奇数还能找到其他匹配的偶数，这个时候也设置当前偶数匹配x
                if (evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)) {
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
}