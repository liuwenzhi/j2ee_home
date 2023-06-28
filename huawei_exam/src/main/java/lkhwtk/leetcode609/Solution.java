package lkhwtk.leetcode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 609. 在系统中查找重复文件
 * 个人思路：基于Map<String,List<String>>数据结构实现
 * 本题题目很长，实际上就是找文件内容即括号里边的内容一致的文件，把这些文件的目录放到一起输出
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String path:paths){
            //本题可以直接用" "进行分隔，用\\s+这种形式进行分隔，会导致增加将近8成不到1倍的时间
            String[] temp = path.split("\\s+");
            String dir = temp[0];
            for(int i=1;i<temp.length;i++){
                String[] fileContent = temp[i].split("\\(");
                String file = fileContent[0];
                //String content = temp[i].split("\\(")[1].split("\\)")[0];
                String content = fileContent[1].replace("\\)","");
                String fullDir = dir+"/"+file;
                /*List<String> list = map.get(content);
                if(list==null||list.size()==0){
                    list = new ArrayList<>();
                }*/
                List<String> list = map.getOrDefault(content,new ArrayList<>());
                list.add(fullDir);
                map.put(content,list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).size()>1){
                result.add(map.get(key));
            }
        }
        return result;
    }
}
