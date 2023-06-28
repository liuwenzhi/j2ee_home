package lkhwtk.leetcode318;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考题解：官方
 * 对Solution方法的优化，对于字符串存在相同的字符集合，只保留最长的即可，
 * 比如aaaaaaaaaaaaaabbbbbbbbbbbbbbbcccccccccccc和abc,字母掩码相同，没必要再算一遍abc了，借助一个hashmap，
 * key是字符串的字母掩码值，value是字符串长度，保留key最长的集合，最后基于这个hashmap进行计算，注意遍历hashmap的方式
 * 注意：这个优化思路想法挺好，但是实际没有太大的时间优化。
 */
public class Solution1 {
    public int bitNumber(char ch){
        //直接返回即可：return ch - 'a';
        return (int)ch - (int)'a';
    }

    public int maxProduct(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                // add bit number bitNumber in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            //对于字符串存在相同的字符集合，只保留最长的即可，比如aaaaaaaaaaaaaabbbbbbbbbbbbbbbcccccccccccc和abc,字母掩码相同，没必要再算一遍abc了
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int maxProd = 0;
        for (int x : hashmap.keySet()) {
            for (int y : hashmap.keySet()) {
                if ((x & y) == 0) {
                    maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));
                }
            }
        }
        return maxProd;
    }
    public static void main(String[] args){
        System.out.println(1&2);
    }

}
