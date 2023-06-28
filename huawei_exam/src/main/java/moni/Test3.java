package moni;

import java.util.Scanner;

/**
 * TODO：本题未确认注释，单引号和双引号等会产生什么影响
 */
public class Test3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while(scanner.hasNext()){
            //因为存在换行的文本，在while循环中把一行一行输入的文本拼起来成为一个字符串
            stringBuilder.append(scanner.nextLine());
        }
        String[] temp = stringBuilder.toString().split(";");
        //文本数量
        int textNum  = temp.length;
        for(int i=0;i<temp.length;i++){
            /*去掉无字符，空字符和制表符，注意有一个细节，如果是;;这种字符串，在根据;进行拆分数组的时候，
            不会单独拆除一个元素，不会走下边的判断，如果是;    ;这种会单独拆除一个空元素放到数组中，下边判断进行递减*/
            if(temp[i].split("\\s+").length==0){
                textNum--;
            }
        }
        System.out.println(textNum);
    }
}
