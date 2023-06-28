package com.duomu.hj64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    /**
     * 歌曲数量小于4
     * @param str 操作序列
     * @param n 歌曲数量
     */
    public static void MP3PlayerLow4(String str, int n) {
        char[] ch = str.toCharArray();
        // 起始序号，当前歌曲序号，当歌曲数量小于4时，不需要调整begin的值，开始位置一直不变
        int begin = 1, cur = 1;
        for (int i = 0; i < ch.length; i++) {
            if (cur == 1 && ch[i] == 'U') { // 光标在第一首歌曲上时，按Up键光标
                cur = n;
                continue;
            }
            if (cur == n && ch[i] == 'D') { // 光标在最后一首歌曲时，按Down键光标
                cur = 1;
                continue;
            }
            if (ch[i] == 'U') {
                cur -= 1;
            }
            if (ch[i] == 'D') {
                cur += 1;
            }
        }
        //输出界面歌曲信息
        for (int i = 0; i < n; i++) {
            if (i==0) {
                System.out.print(begin);
            }else{
                System.out.print(" "+(begin+i));
            }
        }
        System.out.println();
        //当前位置
        System.out.println(cur);
    }

    /**
     * 歌曲数量大于4
     * @param str 操作序列
     * @param n 歌曲数量
     */
    public static void MP3PlayerUp4(String str, int n) {
        char[] ch = str.toCharArray();
        //起始序号，当前歌曲序号，注意不论在哪一页，begin都是开头位置，begin+3是结束位置
        int begin = 1, cur = 1;
        for (int i = 0; i < ch.length; i++) {
            if (begin==1 && cur == 1 && ch[i] == 'U') { // 光标在第一页 ,第一首歌曲上时,按Up键光标
                cur = n;
                //一页只能显示4首歌曲，此时界面显示的歌曲列表编号：n-3,n-2,n-1,n (按照题干即7 8 9 10)
                begin = n-3;
                continue;
            }
            if (begin==n-3 && cur == n && ch[i] == 'D') { // 光标在最后一页,最后一首歌曲时，按Down键光标，此时cur和begin都回到了起始位置
                cur   = 1;
                begin = 1;
                continue;
            }
            if (ch[i] == 'U' && begin==cur ) { 	// 光标在非第一页，第一首歌曲时，按Up键后，从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
                cur  -= 1;
                begin-= 1;
                continue;
            }
            if (ch[i] == 'D' && begin+3==cur) { //非最后一页，begin在开头，cur在末尾，D操作，begin和current都要+1
                cur  += 1;
                begin+= 1;
                continue;
            }
            //光标在其他非首尾的情况，只涉及到移动current，不涉及移动begin，此时不涉及翻页，同页移动
            if(ch[i] == 'U'){
                cur -= 1;
            }else{
                cur += 1;
            }
        }
        System.out.println(begin + " " + (begin + 1) + " " + (begin + 2)+ " " + (begin + 3));
        System.out.println(cur);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            int n = Integer.parseInt(line); // 歌曲数量
            String str = br.readLine(); // 操作序列
            if (n<=4)
                MP3PlayerLow4(str, n);
            else
                MP3PlayerUp4(str, n);
        }
    }
}

