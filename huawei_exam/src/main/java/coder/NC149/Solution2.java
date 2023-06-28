package coder.NC149;

/**
 * 这个能正常跑完，后边有需求再看下。
 */
public class Solution2 {
    public int kmp (String S, String T) {
        // write code here
        int[] next = getNext(S);
        char[] str =T.toCharArray();
        char[] t = S.toCharArray();
        int si =0;
        int ti =0;

        int ans =0;
        while(si < str.length){
            if(ti==-1 || str[si] == t[ti]){
                si++;
                ti++;
            }else{
                ti = next[ti];
            }
            if(ti == t.length){  //改造2
                ans++;
                ti=next[ti];
            }
        }
        return ans;
    }

    public int[] getNext(String S){
        char[] str= S.toCharArray();
        int[] next=  new int[str.length+1]; //改造1
        next[0]=-1;
        next[1] = 0;
        int cur=2;
        int x = next[cur-1];
        while(cur<=str.length){
            if(x==-1 || str[cur-1]==str[x]){
                next[cur++] = ++x;
            }else{
                x=next[x];
            }
        }
        return next;
    }
}
