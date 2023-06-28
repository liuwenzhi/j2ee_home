package lkhwtk.mst0808;

import java.util.HashSet;

/**
 * 面试题 08.08. 有重复字符串的排列组合
 * 本题同offer38题，实际可以参考offer 38题继续优化，本题可能是用例设计的关系，通过
 * set集合配上36行代码，不用设计排序的情况下，时间效率已经能够达到最高，单独的list
 * 集合配上36行代码步行，证明本题通过36行代码方式进行去重还得经过排序才行
 */
public class Solution {
    /**结果数组，初始化HashSet用这种方式，比用Set = HashSet()的方式节省时间*/
    //List<String> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    /**访问标记，1代表已访问，0代表未访问，本题中会存在01反复的替换*/
    int[] visited;
    public String[] permutation(String s) {
        visited = new int[s.length()];
        StringBuilder stringBuilder = new StringBuilder();
        backTrack(s,stringBuilder);
        //list列表转成String数组
        return set.toArray(new String[set.size()]);
    }

    /**
     * @param S 原始字符串
     * @param stringBuilder 缓存字符串
     */
    private void backTrack(String S,StringBuilder stringBuilder){
        //System.out.println(stringBuilder.toString());
        //递归方法出口，StringBuilder可以直接计算length，不用转字符串
        if(stringBuilder.length()==S.length()){
            set.add(stringBuilder.toString());
            return;
        }
        //for循环，每次循环，分别统计以第i的元素开头的排列信息
        for(int i=0;i<S.length();i++){
            if (visited[i] == 1||(i>0&&S.charAt(i)==S.charAt(i-1)&&visited[i-1]==0)) {
                //剪枝
                continue;
            }
            char c = S.charAt(i);
            visited[i] = 1;
            stringBuilder.append(c);
            backTrack(S,stringBuilder);
            // 撤销选择
            visited[i] = 0;
            //撤销选择之后需要删除掉sb的最后一个元素，这个非常重要
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
