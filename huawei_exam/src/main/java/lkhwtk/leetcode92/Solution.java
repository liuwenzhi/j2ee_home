package lkhwtk.leetcode92;

/**
 * 92. 反转链表 II
 * 思路参考：反转链表 II 官方
 * 核心思路：穿针引线，只需要遍历一次单链表，在遍历的过程中，找到待翻转的节点，从第二个节点开始，
 * 依次移动到待翻转列表的最前边的位置，这样只需要遍历一次单链表就能把结果遍历出来
 * 注意：题目中left和right是位置值，从1开始记录
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //定义标记节点，该节点的next指针指向头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        /*注意：本题indexNode一定要直接指向dummyNode，按照下边这种new的方式定义，执行用例[3,5]，移动位置是1,2会报错，*/
        /*ListNode indexNode = new ListNode(-1);
        indexNode.next = head;*/
        ListNode indexNode = dummyNode;
        //将indexNode索引移动到待翻转区域节点的前一个位置left-1，移动完成之后indexNode的next指针指向了left位置的节点
        for(int i=0;i<left-1;i++){
            //indexNode地址改变，走到这个循环中之后，indexNode就和dummyNode不一致了
            indexNode = indexNode.next;
        }
        //定义current指针，初始化为待翻转区域的left位置节点
        ListNode current = indexNode.next;
        ListNode next;
        for(int i=left;i<right;i++){
            next = current.next;
            current.next = next.next;
            //注意：这里不是current，因为current的位置会动，必须是indexNode的next
            next.next = indexNode.next;
            indexNode.next = next;
        }
        //注意：不能直接返回头节点，都节点可能会发生位置移动，比如输入[3,5]，移动位置是1,2
        //return head;
        return dummyNode.next;
    }

    /**
     * main方法中进行了一次验证：不论indexNode采用下边两种方式哪种初始化方式：
     * 方式1：ListNode indexNode = dummyNode;
     * 方式2：
     * ListNode indexNode = new ListNode(-1);
     * indexNode.next = node1;
     * indexNode在向后移动的时候，都不会影响到dummyNode
     */
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = node1;
        ListNode indexNode = dummyNode;
        /*ListNode indexNode = new ListNode(-1);
        indexNode.next = node1;*/
        System.out.println(dummyNode.val+","+dummyNode.next.val);
        System.out.println(indexNode.val+","+indexNode.next.val);
        indexNode = indexNode.next;
        System.out.println("index向后移动一次");
        //dummyNode的值没有变
        System.out.println(dummyNode.val+","+dummyNode.next.val);
        System.out.println(indexNode.val+","+indexNode.next.val);

        //solution.reverseBetween(node1,1,2);
    }
}
