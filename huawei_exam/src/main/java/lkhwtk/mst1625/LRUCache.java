package lkhwtk.mst1625;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.25. LRU 缓存
 * 参考leetcode146提题解，本题和146题在题目表述上有不同，但是实际是一个问题
 */
public class LRUCache {
    /**
     * 单独维护一个内部双向链表
     */
    class DLinkedNode{
        private int key;
        private int value;
        private DLinkedNode prev;
        private DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    /**缓存队列实际大小*/
    private int size;
    /**缓存队列总容量*/
    private int capacity;
    /**缓存map,<key,<key,value>>，链表节点存储key和value，缓存对象存储key和节点*/
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    /**定义一个双向链表的伪头节点和伪尾节点*/
    private DLinkedNode head,tail;

    /**
     * LRU缓存构造方法，初始size，容量，头结点和尾节点，头和尾都是伪节点，用于配合定位节点位置，插入和删除节点等等
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取节点
     * 直接从map缓存中获取，没有就返回-1，有就将该节点移动到链表头，作为最近使用的节点
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }
        //移动到头，返回实际节点值
        moveToHead(node);
        return node.value;
    }

    /**
     * 插入或者修改节点，如果key存在则修改，不存在则新增
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node==null){
            //map缓存中没有这个信息，新建一个节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            //缓存中加入该节点
            cache.put(key,newNode);
            size++;
            //将该新建的节点添加到链表的头部
            addToHead(newNode);
            if(size>capacity){
                //缓存添加元素之后，如果超量了，就删除尾部元素，先从链表中删除该元素，然后在缓存中根据key移除
                DLinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        }else{
            //节点不存在的情况，不需要修改cache了，修改了node对象之后再获取就直接获取到了修改后的node值
            node.value = value;
            //将该节点移动到链表头
            moveToHead(node);
        }
    }

    /**
     * 将双向链表中指定节点添加到头，注意：这里的head节点是一个伪头，addToHead实际是把一个节点放到head的next的位置
     * 题目中，只要是添加元素，都是加到头的位置
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除双向链表中指定节点
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //将当前节点的前置节点和后继节点置为null，不加这个也可以
        node.prev = null;
        node.next = null;
    }

    /**
     * 移动指定节点到头，可以调用已有的两个方法：先删除，再添加到头
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾部，通过伪尾节点找到前置的实际尾节点，删除这个节点
     * 同时返回删除的节点，删除的表尾节点需要返回，在map缓存中还有进一步的删除操作
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
