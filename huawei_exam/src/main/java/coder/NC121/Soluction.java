package coder.NC121;
import java.util.*;

/**
 * 题解：
 * 这道题是常规回溯基本应用，最好是学习了回溯后拿来练手，这次总共碰到了两个坑：
 *
 * 重复问题，一开始用 ArrayList 存，有重复结果，用 TreeSet 解决
 * StringBuilder 删除越界，因为每次删除，我们相当于要删除路径的最后一个字符，而一开始我删除的是第 i 个，那么可能前面的删除了，导致 i 大于当前字符串的最大长度，就越界了
 * PS：回溯法是真的神奇，Duang 的一下，就回溯 = =，同时排列组合问题，一般是回溯法解
 */
public class Soluction {
    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        combination(strs, 0);
        res.addAll(paths);
        return res;
    }
    private void combination(char[] strs, int len) {
        if (len == strs.length) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                combination(strs, len + 1);
                //Duang ~ 回溯 - 状态重置
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
