package lkhwtk.leetcode328;

/**
 * 328. 奇偶链表
 * 个人思路：只用1ms居然时间效率只有7%
 * 本题参考86题拆分链表思路，先做出奇数位链表，然后再做出偶数位链表，再把偶数位链表拼在奇数位链表后边
 * 2021年9月21日优化之后，运行时间0ms，注释部分代码为优化代码
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        //奇数链表哨兵节点
        ListNode oddDummy = new ListNode(-1);
        //奇数链表索引节点，参考86题初始化方式，尽量避免初始化为null
        ListNode oddNode = oddDummy;
        //偶数链表哨兵节点
        ListNode evenDummy = new ListNode(-1);
        //偶数链表索引节点，参考86题初始化方式，尽量避免初始化为null
        ListNode evenNode = evenDummy;
        int index = 1;
        while(head!=null){
            //奇数节点
            if(index%2==1){
                if(oddNode==null){
                    oddDummy.next = head;
                    oddNode = head;
                }else {
                    oddNode.next = head;
                    oddNode = oddNode.next;
                }
            }else{
                //偶数节点
                if(evenNode==null){
                    evenDummy.next = head;
                    evenNode = head;
                }else {
                    evenNode.next = head;
                    evenNode = evenNode.next;
                }
            }
            head = head.next;
            index++;
            //最后关键一步，把原有的链去掉，head虽然移动了，但是链还在保留着，二轮刷题将这一步优化掉
            /*if(index%2==1&&oddNode!=null){
                oddNode.next = null;
            }
            if(index%2==0&&evenNode!=null){
                evenNode.next = null;
            }*/
        }
        //奇数链表后边接上偶数链表
        oddNode.next = evenDummy.next;
        //偶数链表最后一个节点next置为null，避免产生环，前边已经初始化evenNode为dummyNode了，所以即使是只有一个节点的链表，没有偶数位，直接设置next==null也可以，不会报空指针
        //if(evenNode!=null) {
        evenNode.next = null;
        //}
        return oddDummy.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        solution.oddEvenList(node1);
    }
}
