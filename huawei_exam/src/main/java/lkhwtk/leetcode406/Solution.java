package lkhwtk.leetcode406;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 * 思路参考：根据身高重建队列--Java--先排序再插入
 * 官方思路过于复杂，这个先排序再插入这个说的非常好
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按照h降序排序，k升序排序，把初步的大小先排出来
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入，插入按照k，如果k出现相同，会出现小的排在大的前边，符合逻辑
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        //借助LinkedList实现位置插入
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            //在i[1]即K这个位置，插入i这个数组
            list.add(i[1], i);
        }
        //注意列表转二维数组的方式，可以不指定2，这样的话时间消耗小了一些，但是空间大了一些
        return list.toArray(new int[list.size()][2]);
        //return list.toArray(new int[list.size()][]);
        //自定义二维数组转换的方式
        /*int[][] result = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;*/
    }
}
