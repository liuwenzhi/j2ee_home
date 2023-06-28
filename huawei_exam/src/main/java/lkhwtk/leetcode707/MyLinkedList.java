package lkhwtk.leetcode707;

/**
 * 707. 设计链表
 * 参考题解：官方，采用单链表解法
 */
public class MyLinkedList {

    /**
     * size记录链表长度
     */
    private int size;

    /**
     * 哨兵节点，伪node
     */
    private ListNode dummyNode;

    public MyLinkedList() {
        //注意：这里初始化index的大小为0
        size = 0;
        dummyNode = new ListNode(0);
    }

    /** 获取链表中第i个位置的元素（从0开始）， 如果下标无效返回-1*/
    public int get(int index) {
        //size从0开始，链表下标为0,1,2...size-1，实际长度为size
        if (index < 0 || index >= size){
            return -1;
        }
        //直接从头结点开始找
        ListNode curr = dummyNode.next;
        for(int i = 0; i < index; ++i) {
            curr = curr.next;
        }
        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        //添加元素到头部，直接调用添加结点到指定位置方法addAtIndex
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        //添加元素到尾部，直接调用添加结点到指定位置方法addAtIndex
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        //index最大值是size
        if (index > size){
            return;
        }
        if (index < 0){
            index = 0;
        }
        //从dummyNode开始往后找，一直找到index的前一个位置，注意这里和get不同，如果是从dummyNode的next开始找，是找到了index这个位置
        //如果index的大小正好是size，则通过下边的for循环找到了最后一个节点，
        //如果是插入头结点，则直接控制dummyNode的指针next指向这个新增的节点
        ListNode pred = dummyNode;
        for(int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        //创建要添加的结点
        ListNode toAdd = new ListNode(val);
        //要添加的节点next指向pred的next
        toAdd.next = pred.next;
        //pred的next节点指向要添加的节点
        pred.next = toAdd;
        //节点插入完成之后链表长度增加
        ++size;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        //索引无效直接返回
        if (index < 0 || index >= size) return;
        size--;
        //和在指定索引添加结点思路一致，还是从dummyNode开始找，找到要删除位置的前一个位置
        ListNode pred = dummyNode;
        for(int i = 0; i < index; ++i) {
            pred = pred.next;
        }
        // 直接删除
        pred.next = pred.next.next;
    }
}
