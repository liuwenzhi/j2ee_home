package lkhwtk.leetcode1631;

/**
 * 并查集模板参考721题的设计即可，官方题解代码给出了size，setCount实际没有用处
 */
public class UnionFind {
    int[] parent;
    //int[] size;
    //int n;
    // 当前连通分量数目
    //int setCount;

    /*public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        //初始化并查集集合，每一个节点的代表节点是自己
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }*/

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找某个节点的代表节点
     */
    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        //下边是721题使用的查找代表节点模板，测试多了二者相差不多
        /*if (parent[index] != index) {
            parent[index] = findset(parent[index]);
        }
        return parent[index];*/
    }

    /**
     * 合并两个节点
     */
    /*public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        //x和y互换，变换根节点
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }*/

    /**
     * 合并两个节点
     */
    public void unite(int index1, int index2) {
        parent[findset(index2)] = findset(index1);
    }

    /**
     * 判断两个点是否连通，直接找到这两个点的代表节点，判断是否相等
     */
    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }

}
