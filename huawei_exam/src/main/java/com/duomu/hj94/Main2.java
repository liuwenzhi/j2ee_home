package com.duomu.hj94;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 本题采用流的方式实现，可以参考下思路
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int candidateCount = scanner.nextInt();
            List<String> candidates = new ArrayList<>();
            while (candidateCount > 0) {
                String name = scanner.next();
                if (name != null && name.length() > 0 && !candidates.contains(name)) {
                    candidates.add(name);
                }
                candidateCount--;
            }
            int voteCount = scanner.nextInt();
            int[] summary = new int[candidates.size() + 1];
            while (voteCount > 0) {
                String vote = scanner.next();
                if (vote != null && vote.length() > 0) {
                    int index = candidates.indexOf(vote);
                    if (index == -1) {
                        index = summary.length - 1;
                    }
                    summary[index] += 1;
                }
                voteCount--;
            }
            IntStream.rangeClosed(0, summary.length - 1).forEach(it -> {
                if (it != summary.length - 1) {
                    System.out.println(candidates.get(it) + " : " + summary[it]);
                } else {
                    System.out.println("Invalid : " + summary[it]);
                }
            });
        } //Int流遍历打印
    }
}
