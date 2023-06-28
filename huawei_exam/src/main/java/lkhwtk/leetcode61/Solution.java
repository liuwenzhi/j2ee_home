package lkhwtk.leetcode61;

/**
 * 61. 旋转链表
 * 参考题解：【闭合为环】旋转链表
 * 后边循环部分不用想的太麻烦，找到要移动的开始节点，然后直接定义头指针指向这里，
 * 把开始节点之前一个节点的next指针设置为null
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode index = head;
        int length = 1;
        //统计链表长度，index指向head，初始节点数量为1，然后直接让index走到最后一个节点，这
        //样既统计出了列表长度，也能让index指针指向最后一个节点，比初始化length为0，最后走到null效果要好
        while(index.next!=null){
            length++;
            index = index.next;
        }
        //如果链表长度为3，k=4，旋转四次实际相当于旋转一次
        k = k%length;
        if(k==0){
            //如果求余之后得到k等于0，则相当于不旋转
            return head;
        }
        //此时统计完单链表长度之后，index指向了最后一个节点，让最后一个节点的next指向head，此时会产生一个环
        index.next = head;
        //让index沿着这个环继续往下走，走完求余后的n-k长度，此时正好走到新的链表头结点的前一个节点，这里不容易看出来，画一下单链表就可以看出来了
        while(length-k>0){
            index = index.next;
            k++;
        }
        ListNode dummy = index.next;
        index.next=null;
        return dummy;
    }
}
