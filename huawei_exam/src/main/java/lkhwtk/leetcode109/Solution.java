package lkhwtk.leetcode109;

/**
 * 109. 有序链表转换二叉搜索树
 * 参考题解：官方。核心思路：找中位数
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //注意构造树的方式，前闭后开，头结点是head，右边界不包含，可以理解成最右边节点的next节点null
        return buildTree(head, null);
    }

    /**
     * 构造高度平衡的二叉查找树，包含left，不包含right
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        //地归结束条件，链表某个范围段的节点都遍历完了
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        //左右子树去找中位数节点
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * 获取中位数节点，采用快慢指针的方式，快指针和慢指针最开始都是在单链表的最左端，
     * 然后一起往右走，一个走的快走两步，一个走的慢走一步，快指针走到链表尾部的时候，
     * 慢指针的位置就是链表的中位数节点
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        //使用快慢指针找中位数，可以参考下148题，fast指针可以设置为left，也可以是left.next，单链表元素个数为奇数不影响，
        //如果是偶数，left.next找中间偏左，left找中间偏右，本题fast指针在left或者left.next的位置都可以
        ListNode fast = left.next;
        ListNode slow = left;
        //注意这个条件，如果链表的元素个数是奇数，则中位数节点是正中间的节点，
        //如果链表的元素个数是偶数，则中位数节点是中间两个偏右或者偏左的节点，能够保证是
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            //fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        //node7.next = node8;
        System.out.println(solution.getMedian(node1,null).val);
    }

}
