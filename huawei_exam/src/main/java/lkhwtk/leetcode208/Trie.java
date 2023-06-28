package lkhwtk.leetcode208;

/**
 * 208. 实现 Trie (前缀树)
 * 前缀树是一种字典树结构，比如存储apple这个词，实际是按照root->a->p->p->l->e，这种方式，基于这种字典接口能
 * 快速补齐单词，故有一个设计内容：startwith和search如何区分，在这样一个结构上，判断是前缀还是完全匹配，有区别。
 * 前缀树的基本概念可参考下视频：适合新手朋友的视频题解
 *
 * 参考题解： 实现 Trie (前缀树) 官方
 * 本题和820题属于同种类型
 */
public class Trie {
    /**
     * 将前缀树定义为一棵26叉树（每一个叉对应一个小写字母，题目提示信息中提到word和prefix中只包含小写字母）
     */
    private Trie[] children;
    /**节点是否是结束标志，用于区分前缀和完全匹配*/
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        //注意这个设计：前缀树是一个有根树，根并没有字母，起到一个索引的作用，字母要放到根之后，node先指向调用insert方法的前缀树对象
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            //注意：这里一定要有一步判断是否为null，是null就创建一个树对象，再沿着这个树对象往后走
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        //循环结束之后，node的位置是最后一个字母的节点，这个时候设置结束标志为true
        //考虑一种情况app和apple，实际上按照算法中的设计app是重合的，这个时候最后一个p是结束标志，e也是结束标志，可以同时搜索app和apple，这个不矛盾，是很好的设计
        node.isEnd = true;
    }

    public boolean search(String word) {
        //拿到前缀最后一个节点，不为null，同时isEnd，返回true
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        //拿到前缀最后一个节点，不为null，返回true
        return searchPrefix(prefix) != null;
    }

    /**
     * 查找前缀中间方法，如果能匹配上，就把最后一个节点返回，可以拿到这个节点的end信息
     */
    private Trie searchPrefix(String prefix) {
        //node先指向根节点，指向调用searchPrefix这个方法的前缀树对象上
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            //沿着前缀树找不到具体的潜水或者完整的单词返回null
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
