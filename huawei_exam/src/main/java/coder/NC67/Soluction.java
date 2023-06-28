package coder.NC67;

import java.util.ArrayList;

public class Soluction {
    private ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> getSolution(int n) {
        //把n个盘子，从from上借助mid移动到to
        hanoi(n,"left","mid","right");
        return result;
    }

    /*
     * 把n个盘子从from移动到to
     */
    private void hanoi(int n, String from, String mid, String to) {
        if(n==1)
            //只有一个盘子直接移动
            result.add("move from "+from+" to "+to);
        else{
            //把from上最上边的n-1个盘子借助于to移动到mid上
            hanoi(n-1,from,to,mid);
            //把from上最后一个盘子借助于mid移动到to上
            hanoi(1,from,mid,to);
            //把mid上n-1个盘子借助于from移动到to上
            hanoi(n-1,mid,from,to);
        }
    }
}
