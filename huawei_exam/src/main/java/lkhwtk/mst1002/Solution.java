package lkhwtk.mst1002;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * 个人思路
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs==null||strs.length==0){
            return result;
        }
        //定义一个整形数组，长度26位，用于入参字符串中小写字母的比较
        int[] cache = new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        //map用于存放结构相同的字符串，其中key是通过cache缓存取出来的共同的字符出现次数数值拼接的字符串，比如abc和cba，拼出来就是11100000.....
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            //每次清空cache缓存数组，清空stringBuilder缓存key
            Arrays.fill(cache,0);
            stringBuilder.setLength(0);
            //在cache数组中将出现的字母位累加，a-第0位,b-第1位,c-第2位...z-25
            for(int j=0;j<strs[i].length();j++){
                cache[strs[i].charAt(j)-'a']++;
            }
            //将cache数组中全部数字拼成一个key
            for(int c:cache){
                stringBuilder.append(c);
            }
            List<String> list = map.getOrDefault(stringBuilder.toString(),new ArrayList<>());
            list.add(strs[i]);
            map.put(stringBuilder.toString(),list);
        }
        for (String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args){
        //数字转字母，直接强转
        System.out.println((char)97);
        //字母转数字，也可以直接这么强转
        System.out.println((int)'a');
    }
}
