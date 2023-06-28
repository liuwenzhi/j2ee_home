package lkhwtk.leetcode117;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 个人思路，基于广度优先遍历，再加一个List列表存储每次数据，时间效率相对较低
 */
public class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        List<Node> nodeList = new ArrayList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            //先把每一层的节点都拿出来，放到list列表中，同时设置好next
            Node node1 = nodeQueue.poll();
            nodeList.add(node1);
            for(int i=1;i<size;i++){
                Node node = nodeQueue.poll();
                node1.next = node;
                nodeList.add(node);
                node1 = node;
            }

            //遍历当前层全部节点，把子节点都放到队列中
            for(Node node:nodeList){
                if(node.left!=null){
                    nodeQueue.offer(node.left);
                }
                if(node.right!=null){
                    nodeQueue.offer(node.right);
                }
            }
            nodeList.clear();
        }
        return root;
    }
}
