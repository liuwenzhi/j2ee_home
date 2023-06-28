package coder.NC133;

/**
 * NC133 链表的奇偶重排
 * 本题同leetcode328题
 */
public class Solution {
    public ListNode oddEvenList (ListNode head) {
        // write code here
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
}
