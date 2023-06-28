package lkhwtk.mst0206;

/**
 * 面试题 02.06. 回文链表
 * 参考题解：快慢指针解决
 * 核心思路：通过快慢指针找到中间的节点，反转链表后半部分判断是否和前半部分相同
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        //找中间节点
        ListNode midNode = findMidNode(head);
        //从中间节点的下一个位置开始反转后半部分链表
        ListNode secondHalfHead = reverseLinked(midNode.next);
        ListNode curr1 = head;
        ListNode curr2 = secondHalfHead;
        boolean palindrome = true;
        while(palindrome && curr2 != null){
            if(curr1.val != curr2.val) {
                palindrome = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return palindrome;
    }

    /**
     * 反转链表，核心思路：反转单链表需要借助三个临时指针，一个前置指针，一个当前位置指针，
     * 还需要一个充当临时节点的指针，避免next指针方向改变后，前后单链表割裂
     * 1->2->3->4
     * 1<-2<-3<-4
     */
    private ListNode reverseLinked(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            //temp作为临时节点指针，指向当前节点下一个，因为马上要改变cur.next为前一个节点
            ListNode temp = cur.next;
            //改变cur的next为指向前一个节点prev
            cur.next = prev;
            //前一个节点向后移动到cur位置
            prev = cur;
            //cur向后移动到temp位置
            cur = temp;
        }
        //基于反转算法，循环结束后，cur是null，prev为头结点，注意一个点：算法中每相邻两个赋值等式之间存在细致的逻辑关系，当前等式后边元素，是下一个等式的左边元素
        return prev;
    }

    /**
     * 快慢指针寻找中间节点
     * 可以配合下题解中的图解来理解，链表节点数可能包括奇数个，可能包括偶数个
     * 如果是奇数个节点，走到正中间，如果是偶数个节点，走到中间偏左的节点
     */
    private ListNode findMidNode(ListNode head){
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
        ListNode temp = head;
        System.out.println("反转前：");
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("反转后");
        temp = solution.reverseLinked(head);
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
