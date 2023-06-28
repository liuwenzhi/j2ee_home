package player3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2021年华为机试第三题，实际和hj71题一样
 * 40%，拿下这些可以了。
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            StringBuilder result = new StringBuilder();
            String[] temp = line.split(" ");
            //规则信息
            String regix = br.readLine();
            for(int i=0;i<temp.length;i++){
                if(check(temp[i],regix)){
                    result.append(i).append(",");
                }
            }
            if(result.toString().length()>1){
                System.out.println(result.toString().substring(0,result.toString().length()-1));
            }else{
                System.out.println(result.toString());
            }
        }
    }

    public static boolean check(String word,String regix){
        int i=0,j=0;
        while(i<word.length()&&j<regix.length()){
            //点匹配一个字符
            if(".".equals(regix.charAt(j)+"")){
                i++;
                j++;
            }else if("*".equals(regix.charAt(j)+"")){
                //遇到*直接让i往后走
                i++;
            }else{
                if(word.charAt(i)!=regix.charAt(j)){
                    return false;
                }
                i++;
                j++;
            }
        }
        if(i!=word.length()||(j!=regix.length()&&!regix.endsWith("*"))){
            return false;
        }
        return true;
    }
}
