package lkhwtk.leetcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 参考思路：带random指针的链表复制
 * 本题题解中有使用递归思路进行实现的算法，二轮复习时感兴趣就看下
 * 本题接思路很直接：直接按照原来的链表创建一遍node对象，存到map里边，key是原始node对象，value就克隆的node对象
 * 然后再从map里边拿出来创建一遍，其中random和next可以直接通过key获取，提取的也是新创建的node对象，这个思路非常巧
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Node index = head;
        Map<Node,Node> map = new HashMap<>();
        while(index!=null){
            map.put(index,new Node(index.val));
            index = index.next;
        }
        index = head;
        while(index!=null){
            //map集合中，key是原始的node对象，next和random两个属性可以直接从对应的key中提取
            map.get(index).next = map.get(index.next);
            map.get(index).random = map.get(index.random);
            index = index.next;
        }
        return map.get(head);
    }

}
