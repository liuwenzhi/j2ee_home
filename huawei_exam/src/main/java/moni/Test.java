package moni;

public class Test {
    public static void main(String[] args){
        String s = "    ";
        System.out.println(s.split("\\s+").length);
        String s1 = "command;;";
        String[] temp = s1.split(";");
        for(int i=0;i<temp.length;i++){
            if(temp[i].split("\\s+").length==0){
                System.out.print("无字符，空字符串，制表符:");
            }else{
                System.out.print("非无字符，非空字符串，非制表符:");
            }
            System.out.println(temp[i]);
        }
    }
}
