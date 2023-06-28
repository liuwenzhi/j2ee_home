package lkhwtk.leetcode1019;

/**
 * 1019. 链表中的下一个更大节点
 * 个人思路：直接一个一个遍历，效率比较低
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode left = head;
        ListNode right = head;
        //统计下单链表的长度
        while(left!=null){
            length++;
            left = left.next;
        }
        //统计完成后，left回到head位置
        left = head;
        int[] result = new int[length];
        //如果单链表只有一个节点，下边的while循环中，可以包含这一步
        /*if(length == 1){
            result[0] = 0;
            return result;
        }*/
        int index = 0;
        while(index<length&&left!=null){
            //遍历到最后一个元素的情况
            if(left.next==null){
                result[index] = 0;
                break;
            }else{
                right = left.next;
                boolean flag = false;
                while(right!=null){
                    if(right.val>left.val){
                        result[index] = right.val;
                        flag = true;
                        break;
                    }
                    right = right.next;
                }
                //没有找到更大的值，结果设置为0
                if(!flag) {
                    result[index] = 0;
                }
                index++;
                left = left.next;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        solution.nextLargerNodes(head);
    }
}
