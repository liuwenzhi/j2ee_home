package lkhwtk.leetcode870;

import java.util.*;

/**
 * 这里把关系映射map定义为整形对整形：Map<Integer, Integer> assigned = new HashMap();
 * 参考Main方法中的测试用例：如果B集合有重复的元素，那么就会出现assigned集合长度小于B集合的长度，Solution中使用了一个列表，保证和重复元素比对的每一个A中的元素
 * 都能被保存到列表中，如果只存一个值，会造成结果中，重复元素丢数据的情况。本题如果这么做，测试用例能通过87%，剩余9个用例通过不了。
 */
public class Solution1 {
    /**
     * 每次都找B中最小的那张牌，集合A中也是找最小的那张牌逐次和B中最小这个牌比较
     */
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);
        //定义一个B和A的关联map，Map如果value泛型不设置为一个集合对象，那么不好判断到底有没有存入比对的A中的值，0可能也是牌面
        Map<Integer, Integer> assigned = new HashMap();
        for (int b: B) {
            assigned.put(b, -1);
        }
        //单独定义一个集合存放A中不能和B进行比对的牌，这里用栈的方式，实际是输出不用单独通过数字进行控制，很方便
        Deque<Integer> remaining = new LinkedList();
        //贪心比对，从A中最小的和B中最小的牌进行比对，如果a小，则a进入剩余队列，否则a和b关联放到map中
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                //assigned中实际一个key只存放一个值，add是从尾巴加入，pop是从头取，因为只有一个值，
                // 所以不影响，这里也可以使用push（从头压栈），但是压栈会增加时间，只有一个值用add适合
                //有一个点别蒙：get(sortedB[j++])，获取当前j之后自动j自增，for循环中遍历的是sortedA，j需要自己通过代码控制
                assigned.put(sortedB[j++],a);
            } else {
                //这里也用add，保证了先放入队列的元素先备取出，实际这里使用push也没问题，remaining队列的顺序就没有关系了。
                remaining.add(a);
            }
        }
        //之前Map<Integer, Deque<Integer>>的定义方式非常便于重构集合，不需要多层循环
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            //这个位置有对应的B，找到对应的A中的牌
            if (assigned.get(B[i]) > 0)
                ans[i] = assigned.get(B[i]);
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] A = {2,0,4,1,2};
        int[] B = {1,3,0,0,2};
        solution1.advantageCount(A,B);
    }
}
