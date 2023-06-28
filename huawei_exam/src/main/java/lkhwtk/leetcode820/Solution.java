package lkhwtk.leetcode820;

import java.util.Arrays;

/**
 * 820. 单词的压缩编码
 * 本题参考下208题，字典树（前缀树）
 * 解题思路参考：99% Trie 吐血攻略，包教包会
 * 本题是判断两个单词是否存在后缀包含关系，采用字典树这种前缀树需要在树中倒着插入数据
 * 通过前缀树的设计，本题可以不需要考虑题干中的indices[]
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        //先对单词列表根据单词长度由长到短排序，注意对字符串数组的排序方式，基于兰木达表达式进行自定义排序，漂亮
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;

    }
}
