package lkhwtk.leetcode148;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 148. 排序链表
 * 链表升序排序，自己用笨方法，这个题看下官方思路
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode index = head;
        //有可能输入一个空数组，这里不判断，就会报出数组下标越界
        if(index==null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while(index!=null){
            list.add(index.val);
            index = index.next;
        }
        int a[] = new int[list.size()];
        for(int i=0;i<a.length;i++){
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        ListNode node = new ListNode(a[0]);
        index = node;
        for(int i=1;i<a.length;i++){
            ListNode tempNode = new ListNode(a[i]);
            index.next=tempNode;
            index = index.next;
        }
        return node;
    }
}
