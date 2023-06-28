package coder.NC97;
import java.util.*;
/**
 * NC97 字符串出现次数的TopK问题
 * 核心思路：堆排序自定义比较器，本题中自定义比较器方式思路非常好，之前很少用到。
 */
public class Solution {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        PriorityQueue<MyNode> queue=new PriorityQueue<>(new MyComparator());
        HashMap<String,Integer> map=new HashMap<>();
        for (int i=0;i<strings.length;i++){
            if (map.containsKey(strings[i])){
                map.put(strings[i],map.get(strings[i])+1);
            }else {
                map.put(strings[i],1);
            }
        }
        //入堆，将map的key和value单独封装到一个实体类对象中
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            queue.add(new MyNode(entry.getKey(),entry.getValue()));
        }
        String[][] result=new String[k][2];
        int j=0;
        while (j<k&&!queue.isEmpty()){
            MyNode node=queue.poll();
            result[j][0]=node.val;
            //先取j值，再自增，不用后边单独加一个j++了，这个设计也挺巧妙
            result[j++][1]= String.valueOf(node.num);
        }
        return result;
    }

    class MyNode{
        String val;
        int num;
        MyNode(String val,int num){
            this.num=num;
            this.val=val;
        }
    }

    class MyComparator implements Comparator<MyNode> {
        @Override
        public int compare(MyNode o1, MyNode o2) {
            if (o1.num==o2.num){
                //字典序小的在前 所以 o1 比 o2
                return o1.val.compareTo(o2.val);
            }else {
                //数量大的在前所以 o2 - o1
                return o2.num-o1.num;
            }
        }
    }
}
