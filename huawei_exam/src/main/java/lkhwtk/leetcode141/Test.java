package lkhwtk.leetcode141;

/**
 * 注意下对象比较这个知识点
 */
public class Test {
    public static void main(String[] args){
        ListNode a = new ListNode(2);
        ListNode b = a;
        ListNode c = a;
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(2);
        System.out.println(b==c);//true
        System.out.println(a1==a2);//false
    }
}
