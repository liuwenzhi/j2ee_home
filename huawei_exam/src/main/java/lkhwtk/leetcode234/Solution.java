package lkhwtk.leetcode234;

/**
 * 234. 回文链表
 * 个人思路：将链表元素拷贝到数组，官方题解中将链表元素拷贝到List中，时间性能会更高，但是空间能稍微好一点
 * 拷贝到数组之后采用双指针法进行回文数验证，时空复杂度可以。
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode index = head;
       int length =0;
       while(index!=null){
           length++;
           index = index.next;
       }
       int[] a = new int[length];
       index = head;
       int i = 0;
       while(index!=null){
           a[i++] = index.val;
           index = index.next;
       }
       boolean result = true;
       //双指针法进行回文数验证
       for(int m=0,n=length-1;m<=n;m++,n--){
           if(a[m]!=a[n]){
               result = false;
           }
       }
       return result;
    }
}
