package com.duomu.hj28;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 对Main方法进行优化，之前Long和Integer有点混乱，Main1中直接优化为整形，这种情况下运行时间减少10ms左右
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int N = Integer.parseInt(str);
            int[] nums = new int[N];
            String[] str1 = sc.nextLine().split(" ");
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(str1[i]);
            }
            //这种方式转数组看着高大上，实际效率低很多。
            //Arrays.stream(str1).mapToLong(Long::parseLong).toArray();
            // 偶数部分
            ArrayList<Integer> evens = new ArrayList<>();
            // 奇数部分
            ArrayList<Integer> odds = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (nums[i] % 2 == 0) { // 偶数
                    evens.add(nums[i]);
                } else { // 奇数
                    odds.add(nums[i]);
                }
            }
            //偶数匹配数组
            int[] evensMatch = new int[evens.size()];
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
    private static boolean isPrime(int num) {
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
    public static boolean find(int x, ArrayList<Integer> evens, int[] used, int[] evensMatch) {
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
