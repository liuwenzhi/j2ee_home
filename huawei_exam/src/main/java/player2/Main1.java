package player2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line = br.readLine())!=null) {
            String[] temp = line.split(",");
            List<String> list = new ArrayList<String>();
            for(int i=0;i<temp.length;i++){
                list.add(temp[i]);
            }
            Collections.sort(list,new Comparator<String>() {
                public int compare(String s1,String s2) {
                    int i=0,j=0;
                    while(i<s1.length()&&j<s2.length()){
                        if(s1.charAt(i)>s2.charAt(j)){
                            return 1;
                        }
                        i++;j++;
                    }
                    //s1长，s2短，前边重复
                    if(j==s2.length()){
                        //s1长，s2短
                        if(s1.charAt(s1.length()-1)>s2.charAt(0)){
                            return 1;
                        }else{
                            return -1;
                        }
                    }else{
                        //s2长，s1短
                        if(s2.charAt(s2.length()-1)>s1.charAt(0)){
                            return 1;
                        }else{
                            return -1;
                        }
                    }

                }
            });
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
