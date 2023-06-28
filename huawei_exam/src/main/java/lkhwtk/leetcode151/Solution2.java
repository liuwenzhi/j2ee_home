package lkhwtk.leetcode151;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public String reverseWords(String s) {
        Deque<String> words = new LinkedList<>();
        String[] arr = s.split("\\s+");
        for (String str : arr) {
            words.addFirst(str);
        }
        return String.join(" ", words).trim();
    }
}
