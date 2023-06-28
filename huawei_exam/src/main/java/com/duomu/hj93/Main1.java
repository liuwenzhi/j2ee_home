package com.duomu.hj93;

import java.util.*;

public class Main1 {

    public Main1() {
    }

    private boolean dfs(List<Integer> bag, int target, int i) {
        if (target == 0) return true;
        if (i == bag.size()) return false;
        // dfs搜索，对每个元素，选择或者放弃
        return dfs(bag, target, i + 1) || dfs(bag, target - bag.get(i), i + 1);
    }

    public boolean isPartition(int[] arr) {
        List<Integer> bag = new LinkedList<>();
        for (int i : arr) {
            bag.add(i);
        }
        // sum of 5 - sum of 3
        int diff = 0;
        // sum of others
        int others = 0;
        for (int i = 0; i < bag.size();) {
            if (bag.get(i) % 5 == 0) {
                diff += bag.get(i);
                bag.remove(i);
            }
            else if (bag.get(i) % 3 == 0) {
                diff -= bag.get(i);
                bag.remove(i);
            }
            else {
                others += bag.get(i++);
            }
        }
        if ((others - Math.abs(diff)) % 2 != 0) {
            return false;
        }
        // find if sub sum in bag equals target
        int target = (others - Math.abs(diff)) / 2;
        return dfs(bag, target, 0);
    }

    public static void main(String[] args) {
        Main1 solution = new Main1();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            boolean res = solution.isPartition(arr);
            System.out.println(res);
        }
    }
}
