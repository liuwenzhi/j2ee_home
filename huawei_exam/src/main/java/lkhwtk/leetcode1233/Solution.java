package lkhwtk.leetcode1233;

import java.util.*;

/**
 * 1233. 删除子文件夹
 * 参考题解：TreeSet去"重", 10行以内解决
 * 注意：TreeSet集合具有排序和去重的功能
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        //按字符串长度从小到大排序
        Arrays.sort(folder,(s1, s2)->s1.length()-s2.length());
        /*for(int i=0;i<folder.length;i++){
            System.out.println(folder[i]);
        }*/
        //定义TreeSet集合的过程中，重写比较器Comparator，注意s1和s2位置不能调换，拿s1和s2对比，如果s1满足了等于s2的情况，s1就不加入
        Set<String> set= new TreeSet<>((s1, s2)->{
            //在原有比较器前增加一步判断，compareTo方法返回0是代表相等，还有大于0和小于0的情况，可以点击下边compareTo方法看源码注释
            //s1代表子文件路径长，判断下长路径是否包含短路径，后边一定要给短路径加一个 / ,保证路径能匹配上，而不是短路径后边又跟了空格或者其他字母
            if(s1.contains(s2+"/") && s1.substring(0, s2.length() + 1).equals(s2+"/"))
                return 0;
            return s1.compareTo(s2);
        });
        //将folder集合中全部元素添加到Set集合中，添加成功一个元素，返回true，最终结果是每个元素添加的或计算结果
        Collections.addAll(set,folder);
        //注意将Set集合转List列表方式
        return new ArrayList<>(set);
    }

    public static void main(String[] args){
        String[] folder = {"/ah/al/am","/ah/al"};
        Solution solution = new Solution();
        solution.removeSubfolders(folder);
    }
}
