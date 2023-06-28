package lkhwtk.leetcode820;

/**
 * 前缀树是一个26叉树，每个节点的下一级可能包括26个字母的可能
 */
public class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}
