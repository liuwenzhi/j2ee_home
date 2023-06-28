package lkhwtk.leetcode133;

import java.util.*;

/**
 * BFS思路，重点参考
 */
public class Solution1 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap();
        //将题目给定的节点添加到队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        //克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));
        //广度优先搜索
        while (!queue.isEmpty()) {
            //取出队列的头节点，注意：remove方法不是List接口中定义的方法,本人用队列获取元素一般使用pop方法
            Node n = queue.remove();
            //每一个从队列里边取出来的节点，进行克隆之后，都要添加一遍它的邻居节点的克隆节点，先把邻居节点克隆放到visited集合中，
            //再把克隆的邻居节点添加到克隆的node节点中，按照这个思路，邻居节点不会添加重复，放到visited和给克隆节点添加克隆的邻居节点是分开的过程
            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    //如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    //将邻居节点加入队列中
                    queue.add(neighbor);
                }
                //更新当前节点的邻居列表，注意：一定要从visited里边拿，相对于从队列里边拿出来的n已经是一个新的对象了，包括后边的添加的neighbor也需要从visited里边拿，必须是拷贝的节点
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
