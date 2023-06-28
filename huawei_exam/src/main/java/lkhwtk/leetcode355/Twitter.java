package lkhwtk.leetcode355;

import java.util.*;

/**
 * 355. 设计推特
 * 参考题解：哈希表 + 链表 + 优先队列（经典多路归并问题）（Java）
 * 本题设计数据结构比较有特点，算法直接使用PriorityQueue+单链表的方式，PriorityQueue底层基于堆排序实现
 * 元素的顺序，算法设计中放入PriorityQueue的元素是各个推文队列的队首元素，队首元素如果出队后，如果包含next节点，则继续入队列，然
 * 后继续基于排序决定谁先出队。
 * 2021年9月24日二轮刷题：最初接触这道题是6月份，当时应该对java语言实现堆排序没有概念，单链表也是刚刚接触。本题是一道极好，极具有代表性的数据结构算法设计题目。
 * 备注：PriorityQueue队列基本方法讲解：https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
 * 涉及底层多路排序的实现可以参考下23题。23题也是通过不断比较队首元素，实现队列的多路合并。
 */
public class Twitter {
    /**
     * 用户 id 和推文（单链表）的对应关系，用户全部的推文都以链表的方式存储在对应key为用户id的value中
     * hashmap存储value为单链表，这个设计注意下
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1，直接自定义整形，从0开始
     */
    private static int timestamp = 0;

    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     */
    private static PriorityQueue<Tweet> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        //优先级队列中timestamp大的在前边
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp -o1.timestamp);
    }

    /**
     * Compose a new tweet.
     * 发布一个推文，到用户和推文管理的map：twitter中找是否存在userId的key，没有的话直接把推文加到value里边，
     * 有的话，获取这个用户的推文列表，然后把最新的推文放到最前边
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * 根据用户id信息获取用户自己或者用户关注的用户发布的推文前十条
     */
    public List<Integer> getNewsFeed(int userId) {
        // 由于是全局使用的，使用之前需要清空
        maxHeap.clear();
        //获取用户自己的推特单链表，注意：这个时候获取的是推特单链表的队头元素，不是全部元素
        if (twitter.containsKey(userId)) {
            //offer和add方法语义一致，都是向队列中加入元素
            maxHeap.offer(twitter.get(userId));
        }
        //获取用户关注集合
        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                //获取关注人的推特单链表，加入队列中
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        //从大顶堆中，取出堆顶十条记录
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        //注意：有可能取不到十条记录，所以必须判断堆是否为空
        while (!maxHeap.isEmpty() && count < 10) {
            //获取并删除队首元素
            Tweet head = maxHeap.poll();
            res.add(head.id);

            //队首单链表节点next进队，再根据排序规则排队，maxHeap自动完成
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId 发起关注者 id
     * @param followeeId 被关注者 id
     */
    public void follow(int followerId, int followeeId) {
        // 被关注人不能是自己
        if (followeeId == followerId) {
            return;
        }

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            //如果我还没有关注的内容，则获取到一个空列表，初始化一个Set，存放followeeId，最后和followerId一起存放到following集合中
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            //有我关注的列表，则判断下列表中是否有followeeId，没有就加上
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }


    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId 发起取消关注的人的 id
     * @param followeeId 被取消关注的人的 id
     */
    public void unfollow(int followerId, int followeeId) {
        //不能取消关注自己
        if (followeeId == followerId) {
            return;
        }
        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) {
            return;
        }
        // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
        followingList.remove(followeeId);
    }

    /**
     * 推文类，是一个单链表（结点视角）
     */
    private class Tweet {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }


}
