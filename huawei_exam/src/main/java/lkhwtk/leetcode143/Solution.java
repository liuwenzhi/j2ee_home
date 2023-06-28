package lkhwtk.leetcode143;

import java.util.Deque;
import java.util.LinkedList;

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 143. 重排链表
 * 核心思路：借助于双向队列来实现，可以从头和尾两个方向弹出元素
 * 注意：LinkedList的特点，保证了入队的顺序，比如入队为1 2 3 4
 * 则从头结点弹出为1 2 3 4，从尾节点弹出为4 3 2 1，可通过main方法进行验证
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Deque<ListNode> doubleQueue = new LinkedList<>();
        //prev指向head的next节点，head节点不用做单独的入队列处理
        ListNode prev = head.next;
        //除head节点之外其余节点压入到双向队列中
        while(prev!=null){
            doubleQueue.add(prev);
            prev = prev.next;
        }
        prev = head;
        while(!doubleQueue.isEmpty()){
            prev.next = doubleQueue.pollLast();
            prev = prev.next;
            if(!doubleQueue.isEmpty()){
                prev.next = doubleQueue.pollFirst();
                prev = prev.next;
            }
        }
        //注意最后这一步一定要加，因为节点发生了移动，如果不设置next，最后边这个节点的next指针可能实际指向了中间某个节点，会在返回单链表中产生环
        prev.next = null;
    }

    public static void main(String[] args){
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        /*while(!queue.isEmpty()){
            System.out.println(queue.pollLast());
        }*/
        while(!queue.isEmpty()){
            System.out.println(queue.pollFirst());
        }

    }
}
