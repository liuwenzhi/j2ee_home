package lkhwtk.leetcode191;

/**
 * 记录下本题的坑
 */
public class Test {
    public int hammingWeight(int n) {
        //直接这么做不行，有误差
        /*char[] c = (n+"").toCharArray();
        int num = 0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
                num++;
            }
        }
        return num;*/
        //这么做也不行，有误差
        String s = n+"";
        String s1 = s.replaceAll("1","");
        return s.length()-s1.length();
    }
}
