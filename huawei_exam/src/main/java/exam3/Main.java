package exam3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //操作次数
            int num = Integer.parseInt(scanner.nextLine());
            String[] lines = new String[num];
            for(int i=0;i<num;i++){
                lines[i] = scanner.nextLine();
            }
            getArea(lines);
        }
    }

    private static int getArea(String[] lines){
        int area = 0;
        for(String line:lines){
            String[] temp = line.split("\\s+");
            if("d".equals(temp[0])){
                //画矩形的情况
                area += Math.abs(Integer.parseInt(temp[1])-Integer.parseInt(temp[3]))*Math.abs(Integer.parseInt(temp[2])-Integer.parseInt(temp[4]));
            }else{
                //擦除矩形的情况

            }
        }
        return area;
    }

}
