package lkhwtk.leetcode990;

/**
 * 990. 等式方程的可满足性
 * 参考题解：官方，核心考点：并查集，和684题关联起来一起看下
 * 官方视频对并查集基本概念有讲解
 * 本题核心就是根据等式建立并查集，然后通过不等式判断是否不满足条件
 */
public class Solution {
    public boolean equationsPossible(String[] equations) {
        //初始化一个代表节点集合，初始化的时候，每个节点是自身的父节点，如果没有在euqations里边出现的字母不用管，验证不到
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //遍历每一个==的入参表达式
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        //遍历每一个!=的入参表达式
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                //如果index1和index2能找到相同的代表节点，则说明这两个点是联通的，满足了==的条件
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 设置index1的代表节点为index2，核心思路是一层一层找到index1的父节点，
     * 让后将这个父节点的代表节点设置为index2的代表节点，这样index2和index1进行了联通
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 查找代表节点
     */
    public int find(int[] parent, int index) {
        //一层一层去寻找父节点，这里使用循环替代了686题中的递归方式
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


}
