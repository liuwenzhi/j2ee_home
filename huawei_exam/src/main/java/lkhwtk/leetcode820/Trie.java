package lkhwtk.leetcode820;

/**
 * 构造一棵字典树，插入方法基本和208题设计一致
 */
public class Trie {
    TrieNode root;

    public Trie() {
        //前缀树的root节点是空的，没有值，空的节点的子节点可以包括不同的值，这样一棵前缀树能够表示出多个完全不同的前缀，详细可以看题解中前缀树图
        root = new TrieNode();
    }

    /**
     * 注意：按照当前算法设计，一定是先插入长的，再插入短的，不然存在后缀关系的两个单词isNew会被两次置为true
     */
    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        //倒着插入单词，参考题解可以得知：本题要找的是单词的后缀关系，所以得反着来。
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            //判断是否是新单词，如果先插入长的，再插入短的，短的是长的后缀，那么这里就不会判断成功
            if (cur.children[c] == null) {
                isNew = true;
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        //如果是新单词的话编码长度增加新单词的长度+1，否则不变。注意：每个单词后边都至少要跟一个#，所以新单词长度之后还要加个1
        return isNew? word.length() + 1: 0;
    }
}
