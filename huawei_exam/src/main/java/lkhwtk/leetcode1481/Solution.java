package lkhwtk.leetcode1481;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1481. 官方
 * 参考题解：不同整数的最少数目，核心思路：排序+贪心，这里涉及到对HashMap的排序，注意下题解中的实现方式
 */
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //用map保存arr数组中每一个元素出现次数，后边会根据元素的重复次数进行排序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //取出map中的元素集合，放到一个列表中，该列表中的元素是一个1*2的数组，即每个数组两个元素，分别用于保存key和value
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] keyValue = {entry.getKey(), entry.getValue()};
            list.add(keyValue);
        }
        //根据元素重复次数进行排序
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] keyValue1, int[] keyValue2) {
                return keyValue1[1] - keyValue2[1];
            }
        });
        //ans是最终结果，目前保存的是入参arr数组中全部不重复元素的个数，这里使用map.size比list.size能节省4到5ms，时间效率提升非常大
        int ans = map.size();
        //遍历list列表，单个的元素排在前边，重复元素多的排在后边
        for (int i = 0; i < list.size(); i++) {
            int occ = list.get(i)[1];
            //如果待移除元素个数比小的重复数大，则做差，ans个数减一
            if (k >= occ) {
                --ans;
                k -= occ;
            } else {
                break;
            }
        }
        return ans;
    }
}
