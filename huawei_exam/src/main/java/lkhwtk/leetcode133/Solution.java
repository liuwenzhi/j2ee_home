package lkhwtk.leetcode133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 133. 克隆图
 * 参考题解：官方 DFS思路
 * 注意：本题入参只有一个node，其它的信息都是从这一个node里边取出来的，包括node的val，还有node的邻居列表，
 * 然后还要单独处理邻居列表里边的元素，最终把每一个邻居节点创建出来，包括每一个邻居的val和邻居列表
 */
public class Solution {
    /**key：原node，value：克隆node*/
    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        //如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        //克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        //哈希表存储
        visited.put(node, cloneNode);

        //遍历该节点的邻居并更新克隆节点的邻居列表，这里是深度优先遍历的思路，在遍历node1的过程中，
        //会把node2、node3、node4都克隆完成，并将节点存放在visited里边
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        //返回visited.get(node);比直接返回cloneNode更省时
        return visited.get(node);
        //return cloneNode;
    }


}
